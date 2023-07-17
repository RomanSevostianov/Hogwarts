package ru.hogwarts.school2.services;


import org.springframework.stereotype.Service;
import ru.hogwarts.school2.model.Student;
import ru.hogwarts.school2.repository.StudentRepository;

import java.util.Collection;
import java.util.List;


@Service
public class StudentServices {


   private final StudentRepository studentRepository;


    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent (long id){
        return studentRepository.findById(id).get();
}
    public Student createStudent (Student student){
     return studentRepository.save(student);
    }

    public Student editStudent (Student student){
        return studentRepository.save(student);
    }

    public void removeStudent (long id){
         studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudent() {
        return studentRepository.findAll();

    }


public List<Student> getFindStudentAge (Integer age){
        return studentRepository.findByAge(age);
}
}
