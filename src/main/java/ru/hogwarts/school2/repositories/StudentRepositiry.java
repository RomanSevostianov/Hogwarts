package ru.hogwarts.school2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school2.model.Student;

import java.util.List;


public interface StudentRepositiry extends JpaRepository<Student,Long> {


    List<Student> getAgeFind(long age);

}
