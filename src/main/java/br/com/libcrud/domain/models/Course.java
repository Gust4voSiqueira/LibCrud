package br.com.libcrud.domain.models;

import br.com.libcrud.interfaces.dto.CreateCourseDTO;
import br.com.libcrud.interfaces.dto.UpdateCourseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private Boolean active;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public static Course fromCreateCourseDTO(CreateCourseDTO createCourseDTO) {
        return Course.builder()
                .name(createCourseDTO.name())
                .category(createCourseDTO.category())
                .active(createCourseDTO.active())
                .build();
    }

    public static Course fromUpdateCourseDTO(UpdateCourseDTO updateCourseDTO, Course course) {
        return Course.builder()
                .id(course.getId())
                .created_at(course.getCreated_at())
                .active(course.getActive())
                .name(Objects.requireNonNullElse(updateCourseDTO.name(), course.getName()))
                .category(Objects.requireNonNullElse(updateCourseDTO.category(), course.getCategory()))
                .build();
    }
}
