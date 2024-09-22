package com.example.demo.files.services;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.files.dtos.CreateFileDTO;
import com.example.demo.files.dtos.UpdateFileDTO;
import com.example.demo.files.entities.File;
import com.example.demo.files.repositories.FilesRepository;


@Service
public class FilesService {
	
	private Logger logger = Logger.getLogger(FilesService.class.getName());
	
	@Autowired
	private FilesRepository filesRepository;
	
	
	public ResponseEntity<File> createFile(CreateFileDTO createFileDTO) {
		this.logger.log(Level.INFO, "Iniciando criação de arquivo");
		
		try {
			if(createFileDTO.name() == null) {
				this.logger.log(Level.WARNING, "nome do arquivo não informado");
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
			}
			
			if(createFileDTO.superDirectoryID() == null) {
				this.logger.log(Level.WARNING, "diretório pai não informado");
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
			}
			
			File newFile = new File(createFileDTO.name(), createFileDTO.superDirectoryID());
			
			this.logger.log(Level.WARNING, "Criando novo arquivo no banco");
			newFile = this.filesRepository.save(newFile);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(newFile);
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao criar novo arquivo. Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}	

	public ResponseEntity<ArrayList<File>> findAllFilesByDirectory(UUID superDirectoryId){
		this.logger.log(Level.INFO, "Iniciando busca por arquivos no diretório com ID " + superDirectoryId);
		
		try {
			this.logger.log(Level.WARNING, "Realizando busca pelos arquivos do diretório informado no banco");
			
			ArrayList<File> files = this.filesRepository.findBySuperDirectoryId(superDirectoryId);
			
			if(files == null) {
				this.logger.log(Level.SEVERE, "Nenhum diretório arquivo encontrado no diretório!");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(files);
			
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao buscar pelos arquivos do diretório. Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	public ResponseEntity<File> findFileById(UUID fileId) {
		this.logger.log(Level.INFO, "Iniciando busca por arquivo com ID " + fileId);
			
		try {	
			this.logger.log(Level.INFO, "Buscando arquivo por ID no banco");
			File file = this.filesRepository.findById(fileId).get();
			
			if(file == null) {
				this.logger.log(Level.WARNING, "Nenhum arquivo encontrado");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(file);
			
		} catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao buscar arquivo com ID " + fileId + " Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	public ResponseEntity<File> updateFile(UpdateFileDTO updateFileDTO) {
		this.logger.log(Level.INFO, "Iniciando atualização do arquivo com ID " + updateFileDTO.fileId());

		try {
			if(updateFileDTO.fileId() == null) {
				this.logger.log(Level.WARNING, "ID do arquivo não informado");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

			this.logger.log(Level.WARNING, "Buscando arquivo no banco");
			File file = this.filesRepository.findById(updateFileDTO.fileId()).orElse(null);

			if(file == null) {
				this.logger.log(Level.WARNING, "Nenhum arquivo encontrado");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}

			if(updateFileDTO.name() != null) {
				file.setName(updateFileDTO.name());
			}

			if(updateFileDTO.superDirectoryID() != null) {
				file.setSuperDirectoryId(updateFileDTO.superDirectoryID());
			}

			this.logger.log(Level.WARNING, "Atualizando arquivo no banco");
			file = this.filesRepository.save(file);
			return ResponseEntity.status(HttpStatus.OK).body(file);

		}
		
		catch (Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao atualizar arquivo. Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}

	
	public ResponseEntity<Void> deleteFileById(UUID fileId){
		this.logger.log(Level.INFO, "Iniciando exclusão do arquivo");
		
		try {
			this.logger.log(Level.WARNING, "Deletando arquivo no banco");
			this.filesRepository.deleteById(fileId);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception error) {
			this.logger.log(Level.SEVERE, "Erro ao excluir arquivo. Error: " + error.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
}
