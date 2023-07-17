package ru.hogwarts.school2.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school2.model.Faculty;
import ru.hogwarts.school2.repository.FacultyRepository;


import java.util.List;


@Service

public class FacultyServices {

   public FacultyRepository facultyRepository;

    public void removeFaculty (long id){
       facultyRepository.deleteById(id);
    }

    public Faculty getFaculty (long id){
     return facultyRepository.findById(id).get();

    }

    public Faculty createFaculty (Faculty faculty){
       return facultyRepository.save(faculty);
    }

    public Faculty editFaculty (Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public List<Faculty> getAllFacultyColor(String color) {
        return facultyRepository.findByColor(color);
    }
}
