package dev.rannem.utdanningsvalg.service;


import dev.rannem.utdanningsvalg.dto.StudentRequest;
import dev.rannem.utdanningsvalg.dto.StudentResponse;
import dev.rannem.utdanningsvalg.entities.Student;
import dev.rannem.utdanningsvalg.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class StudentService {


    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToStudentResponse)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public Student getThatStudent(Long id) {
        return studentRepository.findStudentById(id);
    }


    public void register(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstname(studentRequest.getFirstname());
        student.setLastname(studentRequest.getLastname());
        studentRepository.save(student);
    }

    private StudentResponse mapToStudentResponse(Student student) {
        return StudentResponse.builder().firstname(student.getFirstname())
                .lastname(student.getLastname())
                .id(student.getId())
                .build();
    }

}
