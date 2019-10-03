package com.example.demo.courseSchedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseScheduleService {
	@Autowired
	CourseScheduleRepo repo;
	
	public List<CourseSchedule> getAll() {
		List<CourseSchedule> cs=new ArrayList<CourseSchedule>();
		repo.findAll().forEach(cs::add);
		return cs;
	}
	public List<CourseSchedule> getCSbyCourse(int courseId) {
		List<CourseSchedule> cs=new ArrayList<CourseSchedule>();
		repo.findByCourse_courseId(courseId).forEach(cs::add);
		return cs;	
	}
	
	public List<CourseSchedule> getCSbyCourseAndClass(String className,int courseId) {
		List<CourseSchedule> cs=new ArrayList<CourseSchedule>();
		repo.findByclassNameAndCourse_courseId(className, courseId).forEach(cs::add);
		return cs;
		
	}
	
	public List<CourseSchedule> getCScourseIdOrderByStartDate(int courseId) {
		List<CourseSchedule> cs=new ArrayList<CourseSchedule>();
		repo.findByCourse_courseIdOrderByStartDate(courseId).forEach(cs::add);
		return cs;
		
	}
	
	public List<CourseSchedule> getCScourseIdOrderByStartDateDesc(int courseId) {
		List<CourseSchedule> cs=new ArrayList<CourseSchedule>();
		repo.findByCourse_courseIdOrderByStartDateDesc(courseId).forEach(cs::add);
		return cs;
	}
	public List<CourseSchedule> getCSbyCourseId(int[] courseId) {
		List<CourseSchedule> cs=new ArrayList<CourseSchedule>();
		repo.findByCourse_courseIdIn(courseId).forEach(cs::add);
		return cs;	
	}	
}
