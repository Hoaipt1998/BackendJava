package com.cdsg.admission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdsg.admission.model.Candidate;
import com.cdsg.admission.model.Exam;
import com.cdsg.admission.model.Grade;
import com.cdsg.admission.model.Major;
import com.cdsg.admission.model.Subject;
import com.cdsg.admission.service.CandidateService;
import com.cdsg.admission.service.ExamService;
import com.cdsg.admission.service.GradeService;
import com.cdsg.admission.service.MajorService;
import com.cdsg.admission.service.SubjectService;

@SpringBootApplication
public class SpringbootJpaHibernateAdmissionManagementApplication implements CommandLineRunner{
	@Autowired
	private MajorService majorService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ExamService examService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaHibernateAdmissionManagementApplication.class, args);
		System.out.println("Welcome to Admission Management Web Application");
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Candidate> cands = majorService.getCanidatesByMajor(1);
		System.out.println("List of all candidates who have major Network (id=1):");
		for(Candidate c:cands) {
			System.out.println(c.getLastName() + " " + c.getFirstName());
		}
//		Major m = majorService.get(1);
//		System.out.println(m.getName());
//		m.setName("Network ++");
//		majorService.save(m);
//		System.out.println("Save major done!!!!");
//		
//		Candidate cand1 = candidateService.get(1);
//		System.out.println(cand1.getFirstName());
//		cand1.setFirstName("SONMAPMAP");
//		candidateService.save(cand1);
//		System.out.println("Save Candidate MAPMAP done!!!!");

		
		/*
		
		//MajorService test
		Major m = new Major("Network", 4.0);
		m = majorService.save(m);
		System.out.println(m);
		//GradeService test
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(new Subject("Toan"));
		subjects.add(new Subject("Ly"));
		subjects.add(new Subject("Hoa"));
		Grade grade = new Grade("Khoi A", subjects);
		grade = gradeService.save(grade);
		System.out.println("Save Grade: Khoi A");
		//CandidateService test
		Candidate myCandidate = new Candidate("Nguyen","An","1/3/2000","0908232700"
				,"liemht@gmail.com","Male","123 Quang Trung","SaigonTech Tower",
				m,grade);
		myCandidate = candidateService.save(myCandidate);
		System.out.println(myCandidate);
		
		for(Subject s:grade.getSubjects()) {
			System.out.println("SubjectName: " + s.getName());
		}
		
		if(myCandidate.getExam() == null) {
			System.out.println("Exam list in the candidate is NULL.");
			myCandidate.setExam(new ArrayList<Exam>());
		}
		
		//Test input score for Toan, Ly, Hoa
		
		for(Subject s:grade.getSubjects()) {
			Exam e = new Exam(myCandidate,s,9.0);
			myCandidate.getExam().add(e);
			s.getExam().add(e);
			examService.save(e);
			//subjectService.save(s);
		}
		
		//myCandidate.setExam(exams);
		//myCandidate = candidateService.save(myCandidate);
		System.out.println("Entered score for  Toan-Ly-Hoa");
		*/
	}

}
