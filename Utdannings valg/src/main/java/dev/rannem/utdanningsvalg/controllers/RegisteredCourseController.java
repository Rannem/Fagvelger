package dev.rannem.utdanningsvalg.controllers;


import dev.rannem.utdanningsvalg.dto.CourseRegistrationResponse;
import dev.rannem.utdanningsvalg.dto.RegisteredCourseRequest;
import dev.rannem.utdanningsvalg.dto.StudentResponse;
import dev.rannem.utdanningsvalg.service.RegisteredCourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/registercourse")
@AllArgsConstructor
public class RegisteredCourseController {

    private RegisteredCourseService registeredCourseService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisteredCourseRequest registeredCourseRequest) {
        registeredCourseService.register(registeredCourseRequest);
        return new ResponseEntity<>("Course Registration Successful",
                OK);
    }

    @GetMapping("/registeredcourse/{id}")
    public ResponseEntity<List<CourseRegistrationResponse>> showAllRegisteredCourses(@PathVariable Long id) {
        return status(OK).body(registeredCourseService.getAllRegisteredCourses(id));
    }


}
