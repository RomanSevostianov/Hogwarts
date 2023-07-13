package ru.hogwarts.school2.services;


import org.springframework.stereotype.Service;
import ru.hogwarts.school2.model.Student;
import ru.hogwarts.school2.repositories.StudentRepositiry;

import java.util.Collection;
import java.util.List;


@Service
public class StudentServices {


   private final StudentRepositiry studentRepositiry;


    public StudentServices(StudentRepositiry studentRepositiry) {
        this.studentRepositiry = studentRepositiry;
    }

    public Student getStudent (long id){
        return studentRepositiry.findById(id).get();
}
    public Student createStudent (Student student){
     return studentRepositiry.save(student);
    }

    public Student editStudent (Student student){
        return studentRepositiry.save(student);
    }

    public void removeStudent (long id){
         studentRepositiry.deleteById(id);
    }

    public Collection<Student> getAllStudent() {
        return studentRepositiry.findAll();

    }


public List<Student> getFindStudentAge (long age){
        return studentRepositiry.getAgeFind(age);
}
}
