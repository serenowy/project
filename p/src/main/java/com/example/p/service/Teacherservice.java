package com.example.p.service;

import com.example.p.model.Student;
import com.example.p.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Data
public class Teacherservice {
    ArrayList<Teacher> teachers=new ArrayList();
    public ArrayList <Teacher> getTeachers(){
        return teachers;
    }
    public  void addTeachers (Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeachers(Integer id,Teacher teacher){
        for (int i =0 ; i <  teachers.size(); i++){
            if(teachers.get(i).getID()==id){
                teachers.set(i,teacher);
                return true;
            }

        }
        return false;
    }
    public boolean deleteTeacher(Integer id){
        for (int i =0 ; i < teachers.size(); i++){
            if(teachers.get(i).getID()==id){
                teachers.remove(i);
                return true;
            }

        }
        return false;
    }
    public boolean searchId(Integer ID) {
        for (int i = 0; i < teachers.size() ; i++) {
            if(teachers.get(i).getID()== ID)
                return true;
        }
        return false;
    }
    public int oneId(Integer ID) {
        for (int i = 0; i <teachers.size() ; i++) {
            if(teachers.get(i).getID().equals(ID))
                return i ;
        }
        return -1;
    }

    public ArrayList<Teacher> salaryTechers(Integer salary) {
        ArrayList<Teacher> salarys= new ArrayList<>();

        for(int i=0; i<teachers.size();i++)
            if(teachers.get(i).getSalary()>=salary)
              salarys.add(teachers.get(i));


        return salarys;

    }

}
