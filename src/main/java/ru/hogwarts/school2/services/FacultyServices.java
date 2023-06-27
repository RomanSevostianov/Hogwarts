package ru.hogwarts.school2.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school2.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class FacultyServices {

    private Map <Long, Faculty> facultyService = new HashMap<>();
    long id=0;

    public Faculty removeFaculty (Long id){
        return facultyService.remove(id);
    }

    public Faculty getFaculty (Long id){
     return facultyService.get(id);

    }

    public Faculty createFaculty (Faculty faculty){
        faculty.setId(++id);
        facultyService.put(id,faculty);
        return faculty;
    }

    public Faculty editFaculty (Faculty faculty){
        if(facultyService.containsKey(faculty.getId())) {
            return facultyService.put(faculty.getId(),faculty);
        }
            return null;
        }


    public Collection<Faculty> getFindColor(String facultyColor) {
        return facultyService.values().stream()
                .filter(student -> student.getColor()==facultyColor)
                .collect(Collectors.toList());
    }
}
