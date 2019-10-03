package com.example.demo.courseSchedule;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
import com.example.demo.course.Course;
@Entity
@Component
public class CourseSchedule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String className;
	private String classTime;
	private Date startDate;
	private Date endTime;
	@OneToOne
	private Course course;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public CourseSchedule() {
		
	}
	
}
