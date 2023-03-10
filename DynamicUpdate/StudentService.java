package com.implementation.OriyaMadar.DynamicUpdate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author Oriya Madar berlin
 * @link  https://github.com/Oriya-Berlin/Spring-Dynamic-Update
 */

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;




    public StudentModel studentDynamicUpdate(Long id, StudentDto studentUpdateRequest)
    {
        StudentModel student_DB = studentRepository.findById(id).get();

        /**
         *  NOTICE: we're iterating the dto class (StudentDto) and NOT the model class (StudentModel),
         *  we want to control at the user modification abilities, so he will not be able to modify properties
         *  like "id", "isEnabled" etc from security or data quality reasons.
         */
        Field[] fields = StudentDto.class.getDeclaredFields();

        // The mechanism here allow me for example to change only the "lastName" property,
        // so the frontend can send me only the "lastName" property in the "StudentDto" update request
        // and all the other fields (like "firstName","email"...) will defined as a null automatically.
        // Now, we know that all the others fields defined as a null, they will not be iterated at all.

        for (Field field : fields)
        {
            if (Objects.equals(field.getName(),"firstName") && studentUpdateRequest.getFirstName() != null){
                student_DB.setFirstName(studentUpdateRequest.getFirstName());
                continue;
            }
            if (Objects.equals(field.getName(),"lastName") && studentUpdateRequest.getLastName() != null){
                student_DB.setLastName(studentUpdateRequest.getLastName());
                continue;
            }
            if (Objects.equals(field.getName(),"birthDate") && studentUpdateRequest.getBirthDate() != null){
                student_DB.setBirthDate(studentUpdateRequest.getBirthDate());
                continue;
            }
            if (Objects.equals(field.getName(),"email") && studentUpdateRequest.getEmail() != null){
                student_DB.setEmail(studentUpdateRequest.getEmail());
                continue;
            }
        }

        // It is a good practice to always return to the front only DTO and not
        // the entity class, but I ignored that to keep things simple.
        return studentRepository.save(student_DB);
    }




}
