package com.cdsg.admission.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbemdedExamId implements  Serializable{
	    @Column(name = "candidate_id", nullable=false)
	    private Integer candidateId;
	 
	    @Column(name = "subject_id", nullable=false)
	    private Integer subjectId;
	 
	    public  EmbemdedExamId() {}
	 
	    public EmbemdedExamId(Integer candidateId, Integer subjectId) {
			super();
			this.candidateId = candidateId;
			this.subjectId = subjectId;
		}

		
	 
	    
	 
	    public Integer getCandidateId() {
			return candidateId;
		}

		public void setCandidateId(Integer candidateId) {
			this.candidateId = candidateId;
		}

		public Integer getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(Integer subjectId) {
			this.subjectId = subjectId;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	 
	        if (o == null || getClass() != o.getClass())
	            return false;
	 
	        EmbemdedExamId that = (EmbemdedExamId) o;
	        return Objects.equals(this.candidateId, that.candidateId) &&
	               Objects.equals(subjectId, that.subjectId);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(candidateId, subjectId);
	    }
}

