package com.amigoscode.demo.student;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public class StudentCourse {

    @NotNull
    private final UUID studentId;
    private final UUID courseId;
    private final String name;
    private final String department;
    private final String description;
    private final String teacherName;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer grade;

    public StudentCourse(UUID studentId,
                         UUID courseId,
                         String name,
                         String department,
                         String description,
                         String teacherName,
                         LocalDate startDate,
                         LocalDate endDate,
                         Integer grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.name = name;
        this.department = department;
        this.description = description;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grade = grade;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
