package com.cdsg.admission.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsg.admission.dao.SubjectRepository;
import com.cdsg.admission.model.Subject;

@Service
@Transactional
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepo;

	public Subject save(Subject s) {
		return subjectRepo.saveAndFlush(s);
	}

	public List<Subject> listAll() {
		return subjectRepo.findAll();
	}

	public Subject get(Integer id) {
		return subjectRepo.findById(id).get();
	}

	public void delete(Integer id) {
		subjectRepo.deleteById(id);
	}
}
