package edu.hccs.springproject1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    
      @GetMapping("/students")
    public List<Student>  students() throws IOException {
        return readData();
    }

    @GetMapping("/student/{name}")
    public Student student(@PathVariable String name) throws IOException {
        System.out.println("Search by student name here :" + name);
        List<Student> students = readData();
        for (Student student : students){
            if (student.getFirst_name().equalsIgnoreCase(name)){
                System.out.println("Found student" + student);
                return student;
            }
        }
        System.out.println("No student were found with the name "+ name);
        return null;
    }
    @GetMapping("/student")
    public Student  student(@RequestParam String name, @RequestParam String courseNo) throws IOException {
        System.out.println("search student by name: "+ name + "CourseNo" + courseNo);
        List<Student>  students = readData();
        for(Student student : students){
            if(student.getFirst_name().equalsIgnoreCase(name) & student.getCourses().get(0).getCourseNo().equalsIgnoreCase(courseNo)){
                System.out.println("found Student "+student);
                return student;
            }
        }
        System.out.println(" No student found for name "+name);
        return null;
    }
    
    public List<Student> readData() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/Students.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Student> studentList = new ArrayList<>();
        List<Course>  courses = new ArrayList<>();

        String header = bufferedReader.readLine();
        String line = bufferedReader.readLine();

        while (line != null){
            String[] data = line.split(",");
            Course course = new Course(null, line, header, 0, null);
            courses.add(course);
            Student student = new Student(0, line, header, line, courses);
            studentList.add(student);
            line = bufferedReader.readLine();
            courses = new ArrayList<>();
        }
        return studentList;
    }
}
