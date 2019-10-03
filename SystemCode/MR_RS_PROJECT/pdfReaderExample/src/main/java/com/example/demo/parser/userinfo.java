package com.example.demo.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userinfo {
private String name;
private String email;
private String fee;
private int WorkExperience;
private String KeyPositions;
private String TechnicalSkills;
private String degree;
private int CareerPath;
private List<Integer> courses;
public void resetDefault() {
	courses=new ArrayList<Integer>();
	name=null;
	email=null;
	fee=null;
	WorkExperience=0;
	KeyPositions=null;
	TechnicalSkills=null;
	degree=null;
	CareerPath=0;
	
}

public userinfo() {
	courses=new ArrayList<Integer>();
	
}
public void addCourse(int i) {
	courses.add(i);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFee() {
	return fee;
}
public void setFee(String fee) {
	this.fee = fee;
}
public int getWorkExperience() {
	return WorkExperience;
}
public void setWorkExperience(int workExperience) {
	WorkExperience = workExperience;
}
public String getKeyPositions() {
	return KeyPositions;
}
public void setKeyPositions(String keyPositions) {
	KeyPositions = keyPositions;
}
public String getTechnicalSkills() {
	return TechnicalSkills;
}
public void setTechnicalSkills(String technicalSkills) {
	TechnicalSkills = technicalSkills;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public int getCareerPath() {
	return CareerPath;
}
public void setCareerPath(int careerPath) {
	CareerPath = careerPath;
}
public List<Integer> getCourses() {
	return courses;
}
public void setCourses(List<Integer> courses) {
	this.courses = courses;
}

public boolean isCourseInCourseList(int i) {
	if(courses.indexOf(i)!=-1)
		return true;
	else
		return false;
	
}

}
