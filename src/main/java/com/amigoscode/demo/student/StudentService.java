package com.amigoscode.demo.student;
import com.amigoscode.demo.EmailValidator;
import com.amigoscode.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
    }

    List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }

    void addNewStudent(Student student){
        addNewStudent(null,student);
    }

    public void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId)
                .orElse(UUID.randomUUID());
        // TODO: Verify that email is not taken
        if(studentDataAccessService.isEmailTaken(student.getEmail())){
            throw new ApiRequestException(student.getEmail() + " is already taken");
        }

        // TODO: Validate email
        if (!emailValidator.test(student.getEmail())){
            throw new ApiRequestException(student.getEmail() + " Is NOT Valid!");
        }
        // Insert a new student in the database
        studentDataAccessService.insertStudent(newStudentId, student);

        //TODO: Confirm created user and show notification to client

    }

    List<StudentCourse> getAllCoursesForStudent(UUID studentId){
        return studentDataAccessService.selectAllStudentCourses(studentId);
    }
}
