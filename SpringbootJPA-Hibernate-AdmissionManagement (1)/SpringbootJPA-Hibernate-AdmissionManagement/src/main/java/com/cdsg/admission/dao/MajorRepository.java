package com.cdsg.admission.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdsg.admission.model.Candidate;
import com.cdsg.admission.model.Major;

public interface MajorRepository extends JpaRepository<Major, Integer>{
	@Query("SELECT c FROM Candidate c WHERE c.major.id = ?1 ")
	public List<Candidate> getCanidatesByMajor(Integer majorId);
}
