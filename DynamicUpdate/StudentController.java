package com.implementation.OriyaMadar.DynamicUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Oriya Madar berlin
 */

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto student)
    {
       StudentModel response = studentService.studentDynamicUpdate(id, student);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
