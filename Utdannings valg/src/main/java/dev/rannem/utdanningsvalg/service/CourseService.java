package dev.rannem.utdanningsvalg.service;

import dev.rannem.utdanningsvalg.dto.CourseRequest;
import dev.rannem.utdanningsvalg.dto.CourseResponse;
import dev.rannem.utdanningsvalg.dto.StudentResponse;
import dev.rannem.utdanningsvalg.entities.Course;
import dev.rannem.utdanningsvalg.entities.Student;
import dev.rannem.utdanningsvalg.repositories.CourseRepository;
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
public class CourseService {
    private final CourseRepository courseRepository;

    public void register(CourseRequest courseRequest) {
        Course course = new Course();
        course.setTitle(courseRequest.getTitle());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);
    }
    @Transactional(readOnly = true)
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::mapToCourseResponse)
                .collect(toList());
    }

    private CourseResponse mapToCourseResponse(Course course) {
        return CourseResponse.builder().title(course.getTitle())
                .description(course.getDescription())
                .id(course.getId())
                .build();
    }
}

