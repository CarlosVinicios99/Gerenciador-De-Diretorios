package com.example.demo.files.dtos;

import java.util.UUID;

public record CreateFileDTO(String name, UUID superDirectoryID) {

}
