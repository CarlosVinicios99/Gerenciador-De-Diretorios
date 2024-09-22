package com.example.demo.files.dtos;

import java.util.UUID;

public record UpdateFileDTO(UUID fileId, String name, UUID superDirectoryID) {

}
