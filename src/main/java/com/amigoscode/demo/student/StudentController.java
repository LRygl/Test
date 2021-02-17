package com.amigoscode.demo.student;
// Return list of students as JSON back to the client

import com.amigoscode.demo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final  StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //localhost:8080/api/students
    // Return All Existing Students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //localhost:8080/api/courses
    //Return All existing courses
    @GetMapping(path="api/courses")
    public List<Course> getAllCourses() {
        return null;
    }

    // UUID student id is what i am getting back from client
    // Path is string that is expected to be found in the request
    // localhost:8080/api/students/67f3fd5b-4a73-4d2a-bb7d-e108a220451c/courses
    @GetMapping(path = "{studentId}/courses")
    public List<StudentCourse> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId){
        // TODO Finish this part
        // System.out.println(studentId);
        return studentService.getAllCoursesForStudent(studentId);
    }


    //TODO Create Student detail Page
    @GetMapping(path="api/{studentId}")
    public List<Student> getStudentDetail(@PathVariable("studentId") UUID studentId){
        return null;
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Validated Student student){
        studentService.addNewStudent(student);
        //Sysout pro logování - podívat se na logger factory
        System.out.println(student);
    }
}
