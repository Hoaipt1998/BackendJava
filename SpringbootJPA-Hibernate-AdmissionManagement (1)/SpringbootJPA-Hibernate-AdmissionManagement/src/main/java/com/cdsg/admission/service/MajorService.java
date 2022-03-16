package com.cdsg.admission.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cdsg.admission.dao.MajorRepository;
import com.cdsg.admission.model.Candidate;
import com.cdsg.admission.model.Major;
@Service
@Transactional
public class MajorService{
	@Autowired
	private MajorRepository majorRepo;
	public Major save(Major m) {
		return majorRepo.save(m);
	}
	public Major get(Integer id) {
		return majorRepo.findById(id).get();
	}
	
	@Query("SELECT c FROM Candidate c WHERE c.major.id = ?1 ")
	public List<Candidate> getCanidatesByMajor(Integer majorId){
		return majorRepo.getCanidatesByMajor(majorId);
	}
}
