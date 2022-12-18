package com.example.p.controller;

import com.example.p.Api;
import com.example.p.model.Teacher;
import com.example.p.service.Teacherservice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController


@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Teacherconntroller {

    Teacherservice teacherservice;
    public Teacherconntroller(Teacherservice teacherservice){
        this.teacherservice=teacherservice;
    }

    @GetMapping("/teacher")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teacher=teacherservice.getTeachers();
        return ResponseEntity.status(200).body(teacher);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
        teacherservice.addTeachers(teacher);
        return ResponseEntity.status(200).body (new Api("Added Teacher"));
    }
    @PostMapping("/update")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher, Errors errors, @PathVariable String index){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
        boolean isUpdated;
        isUpdated = teacherservice.updateTeachers(id,teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new Api("Updated"));
        }
        return ResponseEntity.status(400).body(new Api("wrong!"));
    }
    @DeleteMapping("/delete")
    public ResponseEntity deletTeacher(@PathVariable @Valid Integer id, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message) ; }
        boolean isDeleted= teacherservice.deleteTeacher(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new Api("Teacher has been deleted"));
        }
        return ResponseEntity.status(400).body(new Api("Wrong id!"));   }


    @GetMapping("/id")
    public ResponseEntity idTeagher(@PathVariable Integer ID){
        if(teacherservice.searchId(ID))
            return ResponseEntity.status(400).body(new Api("not found"));

        return ResponseEntity.status(200).body(teacherservice.oneId(ID));
    }
    @GetMapping("/sal")
    public ResponseEntity salaryTeacher(@RequestBody Integer salary){
        ArrayList<Teacher> salarys = teacherservice.salaryTechers(salary);
        return ResponseEntity.status(200).body(salary);
    }}