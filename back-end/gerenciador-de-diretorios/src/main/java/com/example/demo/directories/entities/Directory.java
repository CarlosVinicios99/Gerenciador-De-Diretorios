package com.example.demo.directories.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABLE_DIRECTORIES")
public class Directory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue
	@Id
	private UUID directoryId;
	
	@Column
	private String name;
	
	@Column(name = "created_timestamp")
	private Long createdTimestamp;
	
	@Column(name = "created_timestamp")
	private Long updatedTimestamp;
	
	@Column(name = "super_directory_id")
	private UUID superDirectoryId;
	
	
	public Directory() {
		
	}
	
	public Directory(String name, UUID superDirectoryId) {
		this.name = name;
		this.superDirectoryId = superDirectoryId;
		this.createdTimestamp = System.currentTimeMillis();
		this.updatedTimestamp = System.currentTimeMillis();
	}

	public Directory(UUID directoryId, String name, Long createdTimestamp, Long updatedTimestamp, UUID superDirectoryId) {
		this.directoryId = directoryId;
		this.name = name;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.superDirectoryId = superDirectoryId;
	}


	public UUID getDirectoryId() {
		return directoryId;
	}

	public void setDirectoryId(UUID directoryId) {
		this.directoryId = directoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Long createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Long getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Long updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public UUID getSuperDirectoryId() {
		return superDirectoryId;
	}

	public void setSuperDirectoryId(UUID superDirectoryId) {
		this.superDirectoryId = superDirectoryId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(createdTimestamp, directoryId, name, superDirectoryId, updatedTimestamp);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Directory other = (Directory) obj;
		return Objects.equals(createdTimestamp, other.createdTimestamp)
			&& Objects.equals(directoryId, other.directoryId) && Objects.equals(name, other.name)
			&& Objects.equals(superDirectoryId, other.superDirectoryId)
			&& Objects.equals(updatedTimestamp, other.updatedTimestamp);
	}
}
