package com.example.demo.directories.dtos;

import java.util.UUID;

public record UpdateDirectoryDTO(UUID directoryId, String name, UUID superDirectoryId) {

}
