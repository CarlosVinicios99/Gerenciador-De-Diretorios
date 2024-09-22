package com.example.demo.files.repositories;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.files.entities.File;

public interface FilesRepository extends JpaRepository<File, UUID>{
	
	public ArrayList<File> findBySuperDirectoryId(UUID superDirectoryId);
	
	public void deleteBySuperDirectoryId(UUID superDirectoryId);
	
}
