package ru.hogwarts.school2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school2.model.Faculty;
import ru.hogwarts.school2.services.FacultyServices;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
 private final FacultyServices facultyServices;

    public FacultyController(FacultyServices facultyServices) {
        this.facultyServices = facultyServices;
    }

    @DeleteMapping("/{id}")
  public ResponseEntity <Faculty> deleteFaculty (@PathVariable long id)
{
    facultyServices.removeFaculty(id);
    return ResponseEntity.ok().build();
}
     @PostMapping ("/faculty")
    public Faculty createFaculty (@RequestBody Faculty faculty)
{
    return facultyServices.createFaculty(faculty);

}

@GetMapping ("/{id}")

    public ResponseEntity <Faculty> getFaculty (@PathVariable Long id){
        Faculty faculty = facultyServices.getFaculty(id);
        if (faculty==null){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);

}

@PutMapping ("/faculty")
    public ResponseEntity <Faculty> upDateFaculty (@RequestBody Faculty faculty){
        Faculty finfFaculty = facultyServices.editFaculty(faculty);
        if (finfFaculty==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(finfFaculty);
}

@GetMapping ("/colorFaculty/{color}")
    public ResponseEntity <List<Faculty>>findFacultyColor (@PathVariable String color) {
        return ResponseEntity.ok(facultyServices.getAllFacultyColor(color));

}

}
