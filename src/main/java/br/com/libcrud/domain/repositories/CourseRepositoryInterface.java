package br.com.libcrud.domain.repositories;

import br.com.libcrud.domain.models.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepositoryInterface  {

    Optional<Course> findByName(String name);
    Optional<Course> findById(Long id);
    void deleteById(Long id);
    Course save(Course course);
    List<Course> findAll();
}
