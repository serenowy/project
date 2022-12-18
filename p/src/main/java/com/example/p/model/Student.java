package com.example.p.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Student {
    private Integer ID;
    private  String Name;
    private Integer age;
    @NotNull(message= "can not null")
   private String  major;
    @Pattern(regexp = "(CS|MATH|Engineer)",message = " major_enum must be CS , MATH , Engineer  ")
  private  String major_enum;
}
