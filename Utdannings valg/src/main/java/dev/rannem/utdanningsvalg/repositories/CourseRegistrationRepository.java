package dev.rannem.utdanningsvalg.repositories;

import dev.rannem.utdanningsvalg.entities.Course;
import dev.rannem.utdanningsvalg.entities.CourseRegistration;
import dev.rannem.utdanningsvalg.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    List<CourseRegistration> findAllByCourse(Course course);
}
