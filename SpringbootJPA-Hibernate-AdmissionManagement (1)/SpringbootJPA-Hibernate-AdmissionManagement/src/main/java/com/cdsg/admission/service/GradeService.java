package com.cdsg.admission.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsg.admission.dao.GradeRepository;
import com.cdsg.admission.model.Grade;

@Service
@Transactional
public class GradeService {
	@Autowired
	private GradeRepository gradeRepo;
	public Grade save(Grade grade) {
		return gradeRepo.save(grade);
	}
}
