package br.com.libcrud.application.ports.input;

import br.com.libcrud.application.usecases.CreateCourseUseCase;
import br.com.libcrud.application.usecases.DeleteCourseUseCase;
import br.com.libcrud.application.usecases.GetCoursesUseCase;
import br.com.libcrud.application.usecases.UpdateActiveCourseUseCase;
import br.com.libcrud.application.usecases.UpdateCourseUseCase;
import br.com.libcrud.interfaces.dto.CreateCourseDTO;
import br.com.libcrud.interfaces.dto.ListCoursesDTO;
import br.com.libcrud.interfaces.dto.UpdateCourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;
    private final GetCoursesUseCase getCoursesUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;
    private final UpdateActiveCourseUseCase updateActiveCourseUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;

    @PostMapping
    public ResponseEntity<Object> createCourse(@RequestBody CreateCourseDTO course) {
        try {
            createCourseUseCase.execute(course);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListCoursesDTO>> listCourses() {
        try {
            return ResponseEntity.ok().body(getCoursesUseCase.execute(null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        try {
            deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> updateActiveCourse(@PathVariable Long id) {
        try {
            updateActiveCourseUseCase.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long id, @RequestBody UpdateCourseDTO updateCourseDTO) {
        try {
            updateCourseUseCase.execute(new UpdateCourseDTO(id, updateCourseDTO.name(), updateCourseDTO.category()));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
