package com.example.demo.course;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
import com.example.demo.ParentCourse.ParentCourse;
import com.example.demo.ExamFee.ExamFee;
import com.example.demo.Fee.Fee;
import com.example.demo.courseSchedule.CourseSchedule;
@Entity
@Component
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private String reference;
	private String partOf;
	@Lob
	private String introduction;
	@Lob
	private String takeAway;
	@Lob
	private String prerequisite;
	@Lob
	private String topicCovered;
	private String duration;
	@ManyToMany(mappedBy = "course")
	private List<ParentCourse> parentCourse;
	/*@OneToOne(mappedBy="course")
	private Fee fee;
	@OneToOne(mappedBy="course")
	private ExamFee examfee;
	@OneToOne(mappedBy="course")
	private CourseSchedule cs;
	public CourseSchedule getCs() {
		return cs;
	}
	public void setCs(CourseSchedule cs) {
		this.cs = cs;
	}
	public ExamFee getExamfee() {
		return examfee;
	}
	public void setExamfee(ExamFee examfee) {
		this.examfee = examfee;
	}
	public Fee getFee() {
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}*/
	public List<ParentCourse> getParentCourse() {
		return parentCourse;
	}
	public void setParentCourse(List<ParentCourse> parentCourse) {
		this.parentCourse = parentCourse;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getPartOf() {
		return partOf;
	}
	public void setPartOf(String partOf) {
		this.partOf = partOf;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getTakeAway() {
		return takeAway;
	}
	public void setTakeAway(String takeAway) {
		this.takeAway = takeAway;
	}
	public String getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}
	public String getTopicCovered() {
		return topicCovered;
	}
	public void setTopicCovered(String topicCovered) {
		this.topicCovered = topicCovered;
	}
	public Course() {
		
	}
}
