package com.cdsg.admission.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsg.admission.dao.CandidateRepository;
import com.cdsg.admission.model.Candidate;

@Service
@Transactional
public class CandidateService {
	@Autowired
	private CandidateRepository canRepo;
	public Candidate save(Candidate candidate) {
		return canRepo.save(candidate);
	}
	public Candidate get(Integer id) {
		return canRepo.findById(id).get();
	}
}
