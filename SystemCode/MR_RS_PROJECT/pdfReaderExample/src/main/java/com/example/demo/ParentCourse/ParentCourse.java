package com.example.demo.ParentCourse;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;
import com.example.demo.course.Course;
@Entity
@Component
public class ParentCourse {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
@ManyToMany
private List<Course> course;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String courseName) {
	name = courseName;
}
public List<Course> getCourse() {
	return course;
}
public void setCourse(List<Course> course) {
	this.course = course;
}

public ParentCourse() {
	
	
}

}
