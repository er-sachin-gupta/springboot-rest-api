package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
            1,
        "Radhe",
        "Krishna"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
        // return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "ramesh").body(student);
    }


    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Radhe", "Krishna"));
        students.add(new Student(2, "Hare", "Krishna"));
        students.add(new Student(3, "Hare", "Rama"));
        students.add(new Student(4, "Radhe", "Radhe"));
//        return new ResponseEntity<>(students, HttpStatus.OK);
        return ResponseEntity.ok(students);
    }

    //http://localhost:8080/students/1/Radhe/Krishna
    // {id} - URI template variable
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(
            @PathVariable int id,
            @PathVariable("first-name") String firstName,
            @PathVariable(("last-name")) String lastName
    ) {
//        return new ResponseEntity<>(new Student(id, firstName, lastName), HttpStatus.OK);
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    //http://localhost:8080/students/query?id=1&firstName=Hare&lastName=Krishna
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(
            @RequestParam("id") int studentId,
            @RequestParam("firstName") String studentFirstName,
            @RequestParam("lastName") String studentLastName
            ) {
        Student student = new Student(studentId, studentFirstName, studentLastName);
        return ResponseEntity.ok(student);
    }


    //http://localhost:8080/students/create
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    //http://localhost:8080/students/id/update
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //http://localhost:8080/students/id/delete
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok(studentId + " Student deleted Successfully!");
    }



}
