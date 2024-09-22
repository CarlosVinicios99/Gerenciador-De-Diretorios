package com.example.demo.files.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABLE_FILES")
public class File implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue
	@Id
	@Column(name = "file_id")
	private UUID fileId;
	
	@Column
	private String name;
	
	@Column(name = "created_timestamp")
	private Long createdTimestamp;
	
	@Column(name = "updated_timestamp")
	private Long updatedTimestamp;
	
	@Column(name = "super_directory_id")
	private UUID superDirectoryId;
	
	
	public File() {
		
	}
	
	public File(UUID fileId, String name, Long createdTimestamp, Long updatedTimestamp, UUID superDirectoryId) {
		this.fileId = fileId;
		this.name = name;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.superDirectoryId = superDirectoryId;
	}
	
	public File(String name, UUID superDirectoryId) {
		this.name = name;
		this.superDirectoryId = superDirectoryId;
		this.createdTimestamp = System.currentTimeMillis();
		this.updatedTimestamp = System.currentTimeMillis();
	}


	public UUID getFileId() {
		return fileId;
	}

	public void setFileId(UUID fileId) {
		this.fileId = fileId;
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
		return Objects.hash(createdTimestamp, fileId, name, superDirectoryId, updatedTimestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		return Objects.equals(createdTimestamp, other.createdTimestamp) && Objects.equals(fileId, other.fileId)
			&& Objects.equals(name, other.name) && Objects.equals(superDirectoryId, other.superDirectoryId)
			&& Objects.equals(updatedTimestamp, other.updatedTimestamp);
	}
}
