package com.cdsg.admission.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdsg.admission.model.EmbemdedExamId;
import com.cdsg.admission.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, EmbemdedExamId>{

}
