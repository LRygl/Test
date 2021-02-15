package com.amigoscode.demo.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Course {
    @NotNull
    private final UUID courseId;
    @NotNull
    private final String courseName;
    @NotNull
    private final String courseDescription;
    @NotNull
    private final String courseDepartment;
    private final String courseTeacherName;

    public Course(
            @JsonProperty("courseId") UUID courseId,
            @JsonProperty("courseName") String courseName,
            @JsonProperty("courseDescription") String courseDescription,
            @JsonProperty("courseDepartment") String courseDepartment,
            @JsonProperty("courseTeacherName") String courseTeacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseDepartment = courseDepartment;
        this.courseTeacherName = courseTeacherName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseDepartment='" + courseDepartment + '\'' +
                ", courseTeacherName='" + courseTeacherName + '\'' +
                '}';
    }

    public UUID getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public String getCourseTeacherName() {
        return courseTeacherName;
    }
}
