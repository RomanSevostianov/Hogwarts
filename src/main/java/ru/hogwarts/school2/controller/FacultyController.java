package ru.hogwarts.school2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school2.model.Faculty;
import ru.hogwarts.school2.services.FacultyServices;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
 private FacultyServices facultyServices;

    public FacultyController(FacultyServices facultyServices) {
        this.facultyServices = facultyServices;
    }

    @DeleteMapping("{id}")
  public ResponseEntity <Faculty> deleteFaculty (@PathVariable long id)
{
    Faculty faculty= facultyServices.removeFaculty(id);
    if (faculty==null){
      return  ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(faculty);
}

     @PostMapping ()
    public Faculty createFaculty (@RequestBody Faculty faculty)
{
    return facultyServices.createFaculty(faculty);

}

@GetMapping ("{id}")

    public ResponseEntity <Faculty> getFaculty (@PathVariable Long id){
        Faculty faculty = facultyServices.getFaculty(id);
        if (faculty==null){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);

}

@PutMapping ()
    public ResponseEntity <Faculty> upDateFaculty (@RequestBody Faculty faculty){
        Faculty finfFaculty = facultyServices.editFaculty(faculty);
        if (finfFaculty==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(finfFaculty);
}

    @GetMapping ("/color/{facultyColor}")
    public ResponseEntity <Collection<Faculty>> findColorFaculty (@PathVariable String facultyColor) {
        Collection<Faculty> result = facultyServices.getFindColor(facultyColor);
        if (result.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);

    }
}
