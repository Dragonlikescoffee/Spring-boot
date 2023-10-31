package edu.hccs.springproject1;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private Long id;
    private String courseNo;
    private String grade;
    private int creditHours;
    private Student student;

    
    public Course(Long id, String courseNo, String grade, int creditHours, Student student) {
        this.id = id;
        this.courseNo = courseNo;
        this.grade = grade;
        this.creditHours = creditHours;
        this.student = student;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCourseNo() {
        return courseNo;
    }
    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public int getCreditHours() {
        return creditHours;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

  
}
