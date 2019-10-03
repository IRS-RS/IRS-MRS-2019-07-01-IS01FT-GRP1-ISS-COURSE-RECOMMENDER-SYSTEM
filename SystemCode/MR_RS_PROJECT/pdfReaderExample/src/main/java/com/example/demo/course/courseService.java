package com.example.demo.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseService {
	@Autowired
	CourseRepo repo;

	public Course getCourseById(int id){
		Optional<Course> c=repo.findById(id);
		if(c.isPresent())
		{
			return c.get();
			
		}
		return null;
		
		
	}
	public Course getOneCourseByName(String courseName) {
		Optional<Course> c=repo.findOneByCourseName(courseName);
		if(c.isPresent())
		{
			return c.get();
			
		}
		else {
			return null;
		}
	}
	public List<Course> getAllCourse(){
		List<Course> c = new ArrayList<Course>();
		repo.findAll().forEach(c::add);
		return c;
		}
	public List<Course> getAllCourseByName(String name) {
		List<Course> c = new ArrayList<Course>();
		repo.findAllByCourseName(name).forEach(c::add);
		return c;	
	}
	public Course getOneCourseByDuration(String duration) {
		Optional<Course> c=repo.findOneByDuration(duration);
		if(c.isPresent())
		{
			return c.get();
			
		}
		else {
			return null;
		}
		
	}
	public List<Course> getAllByDuration(String duration) {
		List<Course> c = new ArrayList<Course>();
		repo.findAllByDuration(duration).forEach(c::add);
		return c;
		
	}
	public List<Course> getByParentCourse(int parentCourseId)
	{
		System.out.println(parentCourseId);
		List<Course> c = new ArrayList<Course>();
		repo.findAllByparentCourse_id(parentCourseId).forEach(c::add);
		return c;
		
	}
	public Course getOneCourseByReference(String reference) {
		Optional<Course> c=repo.findOneByReference(reference);
		if(c.isPresent())
		{
			return c.get();
			
		}
		else {
			return null;
		}
		
	}
	public List<Course> getAllByReference(String reference) {
		List<Course> c = new ArrayList<Course>();
		repo.findAllByReference(reference).forEach(c::add);
		return c;
		
	}
	
	public List<Course> getByIntroduction(String introduction) {
		List<Course> c = new ArrayList<Course>();
		repo.findByIntroductionContaining(introduction).forEach(c::add);
		return c;
		
	}
	public List<Course> getByTopicCovered(String topicCovered) {
		List<Course> c = new ArrayList<Course>();
		repo.findBytopicCoveredContaining(topicCovered).forEach(c::add);
		return c;
		
	}	
	public List<Course> getByTakeAway(String takeAway) {
		List<Course> c = new ArrayList<Course>();
		repo.findBytakeAwayContaining(takeAway).forEach(c::add);
		return c;
		
	}
	public List<Course> getByCourseIdin(int[] courseid) {
		List<Course> c = new ArrayList<Course>();
		repo.findByCourseIdIn(courseid).forEach(c::add);
		return c;
		
	}
	
}

