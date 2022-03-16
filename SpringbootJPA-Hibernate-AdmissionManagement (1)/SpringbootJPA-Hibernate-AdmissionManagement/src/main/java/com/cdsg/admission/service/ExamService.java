package com.cdsg.admission.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsg.admission.dao.ExamRepository;
import com.cdsg.admission.model.Exam;

@Service
@Transactional
public class ExamService {
	@Autowired 
	private ExamRepository examRepo;
	public Exam save(Exam e) {
		return examRepo.save(e);
	}
}
