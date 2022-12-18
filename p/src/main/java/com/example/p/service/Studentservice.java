package com.example.p.service;

import com.example.p.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@AllArgsConstructor
@Data
public class Studentservice {

    ArrayList<Student> students=new ArrayList();
    public ArrayList <Student> getStudents(){
        return students;
    }
    public  void addStudent (Student student){
        students.add(student);
    }

    public boolean updateStudent(Integer id,Student student){
        for (int i =0 ; i <  students.size(); i++){
            if( students.get(i).getID()==id){
                students.set(i,student);
                return true;
            }

        }
        return false;
    }
    public boolean deleteStudent(Integer id){
        for (int i =0 ; i < students.size(); i++){
            if(students.get(i).getID()==id){
                students.remove(i);
                return true;
            }

        }
        return false;
    }
    public boolean searchName(String name) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getName() == name)
                return true;
        }
        return false;
    }
    public boolean searchId(Integer ID) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getID()== ID)
                return true;
        }
        return false;
    }

    public int oneName (String name) {
        for (int i = 0; i <students.size() ; i++) {
            if(students.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }
    public int oneId(Integer ID) {
        for (int i = 0; i <students.size() ; i++) {
            if(students.get(i).getID().equals(ID))
                return i ;
        }
        return -1;
    }


    public ArrayList<Student> majorStudents(String major) {
        ArrayList<Student> majors = new ArrayList<>();
        for(int i=0; i<students.size();i++)
            if(students.get(i).getMajor().equals(major))
                majors.add(students.get(i));
        return majors;
    }

    public ArrayList<Student> ageStudents(Integer age) {
        ArrayList<Student> Ages = new ArrayList<>();
        for(int i=0; i<students.size();i++)
            if(students.get(i).getAge()>=age)
                Ages.add(students.get(i));
        return Ages;
    }

}
