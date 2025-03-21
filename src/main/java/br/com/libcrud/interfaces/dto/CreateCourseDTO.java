package br.com.libcrud.interfaces.dto;

import lombok.Builder;

@Builder
public record CreateCourseDTO(String name, String category, Boolean active) {
}
