package br.com.libcrud.infrastructure.persistence;

import br.com.libcrud.domain.models.Course;
import br.com.libcrud.domain.repositories.CourseRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepositoryImpl extends JpaRepository<Course, Long>, CourseRepositoryInterface {

    Optional<Course> findByName(String name);
}
