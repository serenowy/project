package com.example.p.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Teacher {
    private Integer ID;
    private  String Name;
    @NotEmpty  (message = "all should not be empty")
  private double  salary;

}
