package ru.hogwarts.school2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school2.model.Faculty;


import java.util.List;

public interface FacultyRepository extends JpaRepository <Faculty, Long > {
    List<Faculty> findByColor (String color);
}
