package br.com.libcrud.application.usecases;

import br.com.libcrud.application.UseCase;
import br.com.libcrud.domain.repositories.CourseRepositoryInterface;
import br.com.libcrud.exception.CourseExistsException;
import br.com.libcrud.interfaces.dto.CreateCourseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static br.com.libcrud.domain.models.Course.fromCreateCourseDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateCourseUseCase implements UseCase<CreateCourseDTO, Void> {

    private final CourseRepositoryInterface courseRepositoryInterface;

    @Override
    public Void execute(CreateCourseDTO input) {
        var isCourseExist = courseRepositoryInterface.findByName(input.name());

        if(input.name().isEmpty() || input.category().isEmpty()) {
            throw new RuntimeException("Nome e Categoria são obrigatórios.");
        }

        if(isCourseExist.isPresent()) {
            throw new CourseExistsException("Parece que já existe um curso com este título.");
        }

        var course = fromCreateCourseDTO(input);
        courseRepositoryInterface.save(course);

        return null;
    }
}
