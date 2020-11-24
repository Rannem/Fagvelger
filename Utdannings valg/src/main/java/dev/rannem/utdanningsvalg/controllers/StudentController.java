package dev.rannem.utdanningsvalg.controllers;


import dev.rannem.utdanningsvalg.dto.StudentRequest;
import dev.rannem.utdanningsvalg.dto.StudentResponse;
import dev.rannem.utdanningsvalg.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody StudentRequest studentRequest) {
        studentService.register(studentRequest);
        return new ResponseEntity<>("Student Registration Successful",
                OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> showAllStudents() {
        return status(OK).body(studentService.getAllStudents());
    }

    @GetMapping("student/{id}")
    public ResponseEntity  getThatStudent(@PathVariable Long id) {
        return status(OK).body(studentService.getThatStudent(id));
    }

}
