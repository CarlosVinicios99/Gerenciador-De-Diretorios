package com.example.demo.directories.services;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.directories.dtos.CreateDirectoryDTO;
import com.example.demo.directories.dtos.UpdateDirectoryDTO;
import com.example.demo.directories.entities.Directory;
import com.example.demo.directories.repositories.DirectoriesRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Service
public class DirectoriesService {
	
	private Logger logger = Logger.getLogger(DirectoriesService.class.getName());
	
	@Autowired
	private DirectoriesRepository directoriesRepository;
	
	
	public ResponseEntity<Directory> createDirectory(CreateDirectoryDTO createDirectoryDTO) {
		this.logger.log(Level.INFO, "Iniciando criação de diretório");
		
		try {
			if(createDirectoryDTO.name() == null) {
				this.logger.log(Level.WARNING, "nome do diretório não informado");
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
			}
			
			if(createDirectoryDTO.superDirectoryID() == null) {
				this.logger.log(Level.WARNING, "diretório pai não informado");
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
			}
			
			Directory newDirectory = new Directory(createDirectoryDTO.name(), createDirectoryDTO.superDirectoryID());
			
			this.logger.log(Level.WARNING, "Criando novo diretório no banco");
			newDirectory = this.directoriesRepository.save(newDirectory);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(newDirectory);
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao criar novo diretório. Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}	

	public ResponseEntity<ArrayList<Directory>> findAllDirectoriesInRoot(){
		
		this.logger.log(Level.INFO, "Iniciando busca por diretório raiz");
		
		try {
			this.logger.log(Level.WARNING, "Realizando busca pelo diretório root no banco");
			ArrayList<Directory> directoriesQuery = this.directoriesRepository.findByName("root");
			Optional<Directory> directoryWithMinTimestamp = directoriesQuery.stream()
				.min(Comparator.comparing(Directory::getCreatedTimestamp));

				if (directoryWithMinTimestamp.isPresent()) {
				    Directory rootDirectory = directoryWithMinTimestamp.get();
				    this.logger.log(Level.WARNING, "Realizando busca pelos diretórios presentes no diretório root no banco");
				    directoriesQuery = this.directoriesRepository.findBySuperDirectoryId(rootDirectory.getSuperDirectoryId());
				    return ResponseEntity.status(HttpStatus.OK).body(directoriesQuery);
				}
				
			
			this.logger.log(Level.SEVERE, "Nenhum diretório root encontrado!");
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao buscar pelos diretórios presentes no diretório root. Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	
	public ResponseEntity<Directory> findDirectoryById(UUID directoryId) {
		this.logger.log(Level.INFO, "Iniciando busca por diretório com ID " + directoryId);
		
		try {	
			this.logger.log(Level.INFO, "Buscando diretório por ID no banco");
			Directory directory = this.directoriesRepository.findById(directoryId).get();
			
			if(directory == null) {
				this.logger.log(Level.WARNING, "Nenhum diretório encontrado");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(directory);
			
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao buscar diretório com ID " + directoryId + " Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	
	public ResponseEntity<ArrayList<Directory>> findSubDirectoriesBySupDirectory(UUID superDirectoryId){
		this.logger.log(Level.INFO, "Iniciando buscar por subdiretórios do diretório com ID " + superDirectoryId);
		
		try {
			this.logger.log(Level.WARNING, "Buscando por subdiretórios do diretório informado no banco");
			ArrayList<Directory> subdirectories = this.directoriesRepository.findBySuperDirectoryId(superDirectoryId);
			
			if(subdirectories == null) {
				this.logger.log(Level.WARNING, "Nenhum subdiretório encontrado");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(subdirectories);
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao buscar subdiretórios do diretório com ID " + superDirectoryId + " Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	public ResponseEntity<Directory> updateDirectory(UpdateDirectoryDTO updateDirectoryDTO){
		this.logger.log(Level.INFO, "Iniciando atualização do diretório com ID " + updateDirectoryDTO.directoryId());
		
		try {
			if(updateDirectoryDTO.directoryId() == null) {
				this.logger.log(Level.WARNING, "ID do diretório não informado");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
			this.logger.log(Level.WARNING, "Buscando diretório no banco");
			Directory directory = this.directoriesRepository.findById(updateDirectoryDTO.directoryId()).get();
			
			if(directory == null) {
				this.logger.log(Level.WARNING, "Nenhum diretório encontrado");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			
			if(updateDirectoryDTO.name() != null) {
				directory.setName(updateDirectoryDTO.name());
			}
			
			if(updateDirectoryDTO.superDirectoryId() != null) {
				directory.setSuperDirectoryId(updateDirectoryDTO.superDirectoryId());
			}
			
			this.logger.log(Level.WARNING, "Atualizando diretório no banco");
			
			directory = this.directoriesRepository.save(directory);
			return ResponseEntity.status(HttpStatus.OK).body(directory);
			
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao atualizar diretório. Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	/*
	 deleteDirectory
	*/
}
