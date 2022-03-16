package com.cdsg.admission.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Major")
public class Major {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20 , nullable = false)
	private String name;
	private Double passingScore;
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
	public Double getPassingScore() {
		return passingScore;
	}
	public void setPassingScore(Double passingScore) {
		this.passingScore = passingScore;
	}
	public Major() {
		super();
	}
	public Major(String name, Double passingScore) {
		super();
		this.name = name;
		this.passingScore = passingScore;
	}
	public Major(Integer id, String name, Double passingScore) {
		super();
		this.id = id;
		this.name = name;
		this.passingScore = passingScore;
	}
	public Major(Integer id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "ID: " + this.id + " - Name: " + this.name  + " - Passing score: " + this.passingScore;
	}

}
