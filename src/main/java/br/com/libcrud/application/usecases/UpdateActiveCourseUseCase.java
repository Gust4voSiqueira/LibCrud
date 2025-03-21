package br.com.libcrud.application.usecases;

import br.com.libcrud.application.UseCase;
import br.com.libcrud.domain.repositories.CourseRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateActiveCourseUseCase implements UseCase<Long, Void> {

    private final CourseRepositoryInterface courseRepositoryInterface;

    @Override
    public Void execute(Long input) {
        var course = courseRepositoryInterface.findById(input)
                .orElseThrow(() -> new RuntimeException("Curso nã encontrado."));

        course.setActive(!course.getActive());

        courseRepositoryInterface.save(course);

        return null;
    }
}
