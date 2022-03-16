package com.cdsg.admission.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdsg.admission.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

}
