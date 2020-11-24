package dev.rannem.utdanningsvalg.controllers;


import dev.rannem.utdanningsvalg.dto.CourseRequest;
import dev.rannem.utdanningsvalg.dto.CourseResponse;
import dev.rannem.utdanningsvalg.dto.StudentRequest;
import dev.rannem.utdanningsvalg.dto.StudentResponse;
import dev.rannem.utdanningsvalg.entities.Course;
import dev.rannem.utdanningsvalg.service.CourseService;
import dev.rannem.utdanningsvalg.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CourseRequest courseRequest) {
        courseService.register(courseRequest);
        return new ResponseEntity<>("Course Registration Successful",
                OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> showAllCourses() {
        return status(OK).body(courseService.getAllCourses());
    }
}
