package br.com.libcrud.application.usecases;

import br.com.libcrud.application.UseCase;
import br.com.libcrud.domain.repositories.CourseRepositoryInterface;
import br.com.libcrud.interfaces.dto.UpdateCourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.libcrud.domain.models.Course.fromUpdateCourseDTO;

@Service
@RequiredArgsConstructor
public class UpdateCourseUseCase implements UseCase<UpdateCourseDTO, Void> {

    private final CourseRepositoryInterface courseRepositoryInterface;

    @Override
    public Void execute(UpdateCourseDTO input) {
        var course = courseRepositoryInterface.findById(input.id())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado."));

        if(input.name().isEmpty() || input.category().isEmpty()) {
            throw new RuntimeException("Nome e Categoria são obrigatórios.");
        }

        var updatedCourse = fromUpdateCourseDTO(input, course);

        courseRepositoryInterface.save(updatedCourse);

        return null;
    }
}
