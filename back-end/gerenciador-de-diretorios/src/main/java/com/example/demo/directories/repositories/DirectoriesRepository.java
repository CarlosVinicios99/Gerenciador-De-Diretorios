package com.example.demo.directories.repositories;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.directories.entities.Directory;

@Repository
public interface DirectoriesRepository extends JpaRepository<Directory, UUID>{
	
	public ArrayList<Directory> findByName(String name);
	
	public ArrayList<Directory> findBySuperDirectoryId(UUID superDirectoryId);
}
