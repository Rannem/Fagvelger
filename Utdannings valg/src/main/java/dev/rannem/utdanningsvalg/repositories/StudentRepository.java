package dev.rannem.utdanningsvalg.repositories;

import dev.rannem.utdanningsvalg.entities.Course;
import dev.rannem.utdanningsvalg.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Student findStudentById(Long id);

}
