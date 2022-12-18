package com.example.p.controller;

import com.example.p.Api;
import com.example.p.model.Student;
import com.example.p.service.Studentservice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController


@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Studentcontroller {
    Studentservice studentservice;
    public Studentcontroller(Studentservice studentsetvice){
        this.studentservice=studentsetvice;
    }

    @GetMapping("/student")
    public ResponseEntity getStudent(){
        ArrayList<Student> student =studentservice.getStudents();
        return ResponseEntity.status(200).body(student);
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
        studentservice.addStudent(student);
        return ResponseEntity.status(200).body (new Api("Added student"));
    }
    @PostMapping("/update/{index}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student, Errors errors, @PathVariable String index){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
        boolean isUpdated;
        isUpdated = studentservice.updateStudent(id,student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new Api("Updated"));
        }
        return ResponseEntity.status(400).body(new Api("wrong!"));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deletStudent(@PathVariable @Valid Integer id, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message) ; }
        boolean isDeleted= studentservice.deleteStudent(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new Api("student has been deleted"));
        }
        return ResponseEntity.status(400).body(new Api("Wrong id!"));   }




    @GetMapping("/id")
    public ResponseEntity studentId(@PathVariable Integer ID){

        if(studentservice.searchId(ID))
            return ResponseEntity.status(400).body(new Api("not found"));

        return ResponseEntity.status(200).body(studentservice.oneId(ID));
    }
    @GetMapping("/name")
    public ResponseEntity studentName(@RequestBody String name){

        if(studentservice.searchName(name))
            return ResponseEntity.status(400).body(new Api("not found"));

        return ResponseEntity.status(200).body(studentservice.oneName(name));
    }

    @GetMapping("/major")
    public ResponseEntity studentM(@RequestBody String major){
        ArrayList<Student> majors = studentservice.majorStudents(major);
        return ResponseEntity.status(200).body(majors);
    }
    @GetMapping("/age")
    public ResponseEntity studentAge(@RequestBody Integer age){
        ArrayList<Student> ages = studentservice.ageStudents(age);
        return ResponseEntity.status(200).body(ages);
    }



}


