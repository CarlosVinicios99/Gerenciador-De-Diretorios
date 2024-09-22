package com.example.demo.directories.dtos;

import java.util.UUID;

public record CreateDirectoryDTO(String name, UUID superDirectoryID) {
 
}
