package br.com.libcrud.application.usecases;

import br.com.libcrud.application.UseCase;
import br.com.libcrud.domain.repositories.CourseRepositoryInterface;
import br.com.libcrud.interfaces.dto.ListCoursesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.libcrud.domain.enums.Active.ACTIVE;
import static br.com.libcrud.domain.enums.Active.INACTIVE;

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
                        .active(Boolean.TRUE.equals(course.getActive()) ? ACTIVE.getDescription() : INACTIVE.getDescription())
                        .created_at(course.getCreated_at())
                        .updated_at(course.getUpdated_at())
                        .build())
                .toList();
    }
}
