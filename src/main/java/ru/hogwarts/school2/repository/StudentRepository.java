package ru.hogwarts.school2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school2.model.Student;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByAge(int age);

}
