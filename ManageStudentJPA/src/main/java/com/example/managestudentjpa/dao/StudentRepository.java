/**
 * 
 */
package com.example.managestudentjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managestudentjpa.model.Student;


/**
 * @author ThanhHoai
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
