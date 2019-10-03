package com.example.demo.ExamFee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
import com.example.demo.course.Course;
@Entity
@Component
public class ExamFee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Course course;
	private double examfeeself;
	private double examfeecs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public double getExamfeeself() {
		return examfeeself;
	}
	public void setExamfeeself(double examfeeself) {
		this.examfeeself = examfeeself;
	}
	public double getExamfeecs() {
		return examfeecs;
	}
	public void setExamfeecs(double examfeecs) {
		this.examfeecs = examfeecs;
	}
	public ExamFee() {
		
		
	}
}
