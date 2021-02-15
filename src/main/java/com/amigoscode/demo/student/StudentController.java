package com.amigoscode.demo.student;
// Return list of students as JSON back to the client

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final  StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Validated Student student){
        studentService.addNewStudent(student);
        //Sysout pro logování - podívat se na logger factory
        System.out.println(student);
    }
}
