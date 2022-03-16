package com.saigontech.demo.model;

import org.springframework.stereotype.Component;

@Component
public class BMI {
	private double weight,height;

	public BMI(double weight, double height) {
		super();
		this.weight = weight;
		this.height = height;
	}

	public BMI() {
		super();
		this.weight = 53;
		this.height = 1.65;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public double getBmi() {
		double a = this.weight/(this.height * this.height);
		return a; 	 
	}
	public void printConsoleBMI() {
		double bmi = this.weight/(this.height * this.height);
		System.out.println("BMI is " + bmi);
	}
}
