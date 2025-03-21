package br.com.libcrud.interfaces.dto;

import lombok.Builder;

@Builder
public record UpdateCourseDTO(Long id, String name, String category) {
}
