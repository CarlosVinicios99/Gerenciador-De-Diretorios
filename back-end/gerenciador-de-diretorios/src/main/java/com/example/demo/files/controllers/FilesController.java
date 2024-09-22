package com.example.demo.files.controllers;

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

import com.example.demo.files.dtos.CreateFileDTO;
import com.example.demo.files.dtos.UpdateFileDTO;
import com.example.demo.files.entities.File;
import com.example.demo.files.services.FilesService;

@RestController
@RequestMapping("/files")
public class FilesController {
	
	@Autowired
	private FilesService filesService;
	
	
	@PostMapping
	public ResponseEntity<File> createFile(@RequestBody CreateFileDTO createFileDTO){
		return this.filesService.createFile(createFileDTO);
	}
	
	@GetMapping("/by-directory/{superDirectoryId}")
	public ResponseEntity<ArrayList<File>> findAllFilesByDirectory(@PathVariable UUID superDirectoryId){
		return this.filesService.findAllFilesByDirectory(superDirectoryId);
	}
	
	@GetMapping("/{fileId}")
	public ResponseEntity<File> findFileById(@PathVariable UUID fileId){
		return this.filesService.findFileById(fileId);
	}
	
	@PutMapping
	public ResponseEntity<File> updateDirectory(@RequestBody UpdateFileDTO updateFileDTO){
		return this.filesService.updateFile(updateFileDTO);
	}
	
	@DeleteMapping("/{fileId}") 
	public ResponseEntity<Void> deleteDirectory(@PathVariable UUID fileId){
		return this.filesService.deleteFileById(fileId);
	}
	
}
