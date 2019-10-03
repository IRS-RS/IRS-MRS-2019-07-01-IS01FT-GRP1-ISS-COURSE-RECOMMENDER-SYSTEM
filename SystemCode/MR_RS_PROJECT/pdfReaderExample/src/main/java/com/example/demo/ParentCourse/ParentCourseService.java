package com.example.demo.ParentCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentCourseService {

	@Autowired
	ParentCourseRepo repo;
	
	public List<ParentCourse> getAll() {
		List<ParentCourse> ps=new ArrayList<ParentCourse>();
		repo.findAll().forEach(ps::add);
		return ps;
	}
	
	public ParentCourse getByName(String courseName) {
		Optional<ParentCourse> ps=repo.findByName(courseName);
		if(ps.isPresent()) {
			return ps.get();
		}
		else {
			return null;
		}
	}
	
	public List<ParentCourse> getByCourseId(int courseId){
		List<ParentCourse> ps=new ArrayList<ParentCourse>();
		repo.findByCourse_courseId(courseId).forEach(ps::add);
		return ps;
	}
	
	
	
}
