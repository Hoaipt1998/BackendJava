package com.cdsg.admission.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam implements Serializable{
    private static final long serialVersionUID = -2834827403836993112L;
    @EmbeddedId
    private EmbemdedExamId id = new EmbemdedExamId();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId")
	private Candidate candidate;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("subjectId")
	private Subject subject;
	
	private Double score;

	public Exam(Candidate candidate, Subject subject, Double score) {
		super();
		this.candidate = candidate;
		this.subject = subject;
		this.score = score;
	}

	public Exam(Candidate candidate, Subject subject) {
		super();
		this.candidate = candidate;
		this.subject = subject;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Exam() {
		super();
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Exam that = (Exam) o;
        return Objects.equals(this.candidate, that.candidate) &&
               Objects.equals(this.subject, that.subject);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(candidate, subject);
    }
}