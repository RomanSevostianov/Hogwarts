package ru.hogwarts.school2.services;


import org.springframework.stereotype.Service;
import ru.hogwarts.school2.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServices {

    private Map<Long, Student> servicesStudent = new HashMap ();
    long id=0;


    public Student getStudent (Long id){
   return servicesStudent.get(id);
}

    public Student createStudent (Student student){
       student.setId(++id);
      servicesStudent.put(id,student);
      return student;
    }

    public Student editStudent (Student student){
        servicesStudent.put(student.getId(),student);
        return student;
    }

    public Student removeStudent (Long id){
        return servicesStudent.remove(id);
    }

    public Collection<Student> getAllStudent() {
        return servicesStudent.values();

    }


    public Collection<Student> getFindStudent (int age){
        return servicesStudent.values().stream()
                .filter(student -> student.getAge()==age)
                .collect(Collectors.toList());

    }
}
