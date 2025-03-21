package br.com.libcrud.application.usecases;

import br.com.libcrud.application.UseCase;
import br.com.libcrud.domain.repositories.CourseRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCourseUseCase implements UseCase<Long, Void> {

    private final CourseRepositoryInterface courseRepositoryInterface;

    @Override
    public Void execute(Long input) {
        courseRepositoryInterface.deleteById(input);
        return null;
    }
}
