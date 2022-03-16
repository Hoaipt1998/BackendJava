package com.cdsg.admission.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "grades")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20 , nullable = false)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="grade_subject", 
				joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="subject_id", referencedColumnName = "id"),
				uniqueConstraints=@UniqueConstraint(columnNames = {"book_id","subject_id"}))
	private List<Subject> subjects;

	public Grade(Integer id, String name, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
	}

	public Grade(String name, List<Subject> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
	}

	public Grade() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	
	

}
