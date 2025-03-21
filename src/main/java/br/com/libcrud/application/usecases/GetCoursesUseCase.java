package br.com.libcrud.application.usecases;

import br.com.libcrud.application.UseCase;
import br.com.libcrud.domain.repositories.CourseRepositoryInterface;
import br.com.libcrud.interfaces.dto.ListCoursesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCoursesUseCase implements UseCase<Void, List<ListCoursesDTO>> {

    private final CourseRepositoryInterface courseRepositoryInterface;

    @Override
    public List<ListCoursesDTO> execute(Void input) {
        return courseRepositoryInterface.findAll()
                .stream()
                .map(course -> ListCoursesDTO.builder()
                        .name(course.getName())
                        .category(course.getCategory())
                        .active(course.getActive())
                        .created_at(course.getCreated_at())
                        .updated_at(course.getUpdated_at())
                        .build())
                .toList();
    }
}
