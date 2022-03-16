package com.cdsg.admission.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 10 , nullable = false)
	private String name;
	@JsonBackReference
	@OneToMany(mappedBy = "subject")
	private List<Exam> exam = new ArrayList<Exam>();
	@JsonBackReference
	@ManyToMany(mappedBy = "subjects")
	private List<Grade> grades = new ArrayList<Grade>();

	public Subject(Integer id, String name, List<Exam> exam,List<Grade> include) {
		super();
		this.id = id;
		this.name = name;
		this.exam = exam;
		this.grades = include;
	}
	
	public Subject() {
		super();
	}

	public Subject(String name) {
		super();
		this.name = name;
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

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}



	public List<Grade> getGrades() {
		return grades;
	}



	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	
}
