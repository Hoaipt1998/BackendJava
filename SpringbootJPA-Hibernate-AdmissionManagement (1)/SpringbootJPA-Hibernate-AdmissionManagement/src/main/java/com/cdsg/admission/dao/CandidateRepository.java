package com.cdsg.admission.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdsg.admission.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

}
