package dev.rannem.utdanningsvalg.service;


import dev.rannem.utdanningsvalg.dto.CourseRegistrationResponse;
import dev.rannem.utdanningsvalg.dto.RegisteredCourseRequest;
import dev.rannem.utdanningsvalg.entities.Course;
import dev.rannem.utdanningsvalg.entities.CourseRegistration;
import dev.rannem.utdanningsvalg.entities.Student;
import dev.rannem.utdanningsvalg.repositories.CourseRegistrationRepository;
import dev.rannem.utdanningsvalg.repositories.CourseRepository;
import dev.rannem.utdanningsvalg.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class RegisteredCourseService {

    private final CourseRegistrationRepository courseRegistrationRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public void register(RegisteredCourseRequest registeredCourseRequest) {
        CourseRegistration courseRegistration = new CourseRegistration();

        Student student = studentRepository.findStudentById(registeredCourseRequest.getStudentId());
        Course course = courseRepository.findCourseById(registeredCourseRequest.getCourseId());

        courseRegistration.setStudent(student);
        courseRegistration.setCourse(course);

        courseRegistrationRepository.save(courseRegistration);
    }
    @Transactional(readOnly = true)
    public List<CourseRegistrationResponse> getAllRegisteredCourses(Long courseID) {
        Course course = courseRepository.findCourseById(courseID);
        List<CourseRegistration> students = courseRegistrationRepository.findAllByCourse(course);



        return students.stream().map(this::mapToCourseResponse).collect(Collectors.toList());
    }
    private CourseRegistrationResponse mapToCourseResponse(CourseRegistration courseRegistration) {
        return CourseRegistrationResponse.builder().courseId(courseRegistration.getCourse().getId())
                .studentId(courseRegistration.getStudent().getId())
                .id(courseRegistration.getId())
                .build();
    }
}
