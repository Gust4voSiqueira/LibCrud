package br.com.libcrud.interfaces.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ListCoursesDTO(String name, String category, Boolean active, LocalDateTime created_at, LocalDateTime updated_at) {
}
