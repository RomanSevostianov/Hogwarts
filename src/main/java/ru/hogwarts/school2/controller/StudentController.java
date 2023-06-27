package ru.hogwarts.school2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school2.model.Student;
import ru.hogwarts.school2.services.StudentServices;

import java.util.Collection;


@RestController//в данном классе будет реализованна логика обработки клиентских запросов

@RequestMapping("students")
public class StudentController {

    private StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("{id}")

    public ResponseEntity <Student> getStudentInfo (@PathVariable long id){
        Student student = studentServices.getStudent(id);
        if (student==null){
            return ResponseEntity.notFound().build();
        }
         return ResponseEntity.ok(student);
    }

    @PostMapping // метод обрабатывает Post запросы, создает
    public Student createStudent (@RequestBody Student student){
        return studentServices.createStudent(student);
    }

    @DeleteMapping("{id}")

    public ResponseEntity <Student> deleteStudent (@PathVariable long id){
      Student student = studentServices.removeStudent(id);
      if (student == null){
          return  ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(student);
    }

    @PutMapping () // update запрос

    public ResponseEntity <Student> putStudent (@RequestBody Student student)
    {
       Student finfStudent  = studentServices.editStudent(student);
       if (finfStudent==null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(finfStudent);
    }

    @GetMapping ()
    public ResponseEntity<Collection<Student>> findAllStudent (){
        return ResponseEntity.ok(studentServices.getAllStudent());
    }

@GetMapping ("/age/{StudentAge}")
   public ResponseEntity <Collection<Student>> fingStudentAge (@PathVariable Integer StudentAge){
        Collection<Student> result = studentServices.getFindStudent(StudentAge);
        if (result.size()==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);

}



}
