package com.example.demo.directories.controllers;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.directories.dtos.CreateDirectoryDTO;
import com.example.demo.directories.dtos.UpdateDirectoryDTO;
import com.example.demo.directories.entities.Directory;
import com.example.demo.directories.services.DirectoriesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Directories", description = "Serviços para manipulação de diretórios")
@RestController
@RequestMapping("/directories")
public class DirectoriesController {
	
	@Autowired
	private DirectoriesService directoriesService;
	
	
	@Operation(
		summary = "Cria uma novo diretório"
	)
	@PostMapping
	public ResponseEntity<Directory> createDirectory(@RequestBody CreateDirectoryDTO createDirectoryDTO){
		return this.directoriesService.createDirectory(createDirectoryDTO);
	}
	
	@Operation(
		summary = "Busca o diretório raíz"
	)
	@GetMapping("/root")
	public ResponseEntity<Directory> findRootDirectory(){
		return this.directoriesService.findRootDirectory();
	}
	
	@Operation(
		summary = "Busca um diretório por ID"
	)
	@GetMapping("/{directoryId}")
	public ResponseEntity<Directory> findDirectoryById(@PathVariable UUID directoryId){
		return this.directoriesService.findDirectoryById(directoryId);
	}
	
	@Operation(
		summary = "Busca subdiretórios de um diretório"
	)
	@GetMapping("/{superDirectoryId}/subdirectories")
	public ResponseEntity<ArrayList<Directory>> findSubdirectoriesBySupDirectory(@PathVariable UUID superDirectoryId){
		return this.directoriesService.findSubdirectoriesBySupDirectory(superDirectoryId);
	}
	
	@Operation(
		summary = "Atualiza um diretório"
	)
	@PutMapping
	public ResponseEntity<Directory> updateDirectory(@RequestBody UpdateDirectoryDTO updateDirectoryDTO){
		return this.directoriesService.updateDirectory(updateDirectoryDTO);
	}
	
	@Operation(
		summary = "Excluí um diretório com todo seu conteúdo"
	)
	@DeleteMapping("/{directoryId}") 
	public ResponseEntity<Void> deleteDirectory(@PathVariable UUID directoryId){
		return this.directoriesService.deleteDirectory(directoryId);
	}
	
}
