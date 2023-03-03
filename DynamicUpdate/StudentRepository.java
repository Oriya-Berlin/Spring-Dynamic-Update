package com.implementation.OriyaMadar.DynamicUpdate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oriya Madar berlin
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {
}
