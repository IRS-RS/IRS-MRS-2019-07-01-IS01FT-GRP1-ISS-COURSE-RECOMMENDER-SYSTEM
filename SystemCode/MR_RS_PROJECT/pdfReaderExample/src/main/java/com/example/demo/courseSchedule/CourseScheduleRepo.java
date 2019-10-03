package com.example.demo.courseSchedule;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseScheduleRepo extends CrudRepository<CourseSchedule,Integer> {
	List<CourseSchedule> findByCourse_courseId(int courseId);
	List<CourseSchedule> findByclassNameAndCourse_courseId(String className,int courseId);
	List<CourseSchedule> findByCourse_courseIdOrderByStartDate(int courseid);
	List<CourseSchedule> findByCourse_courseIdOrderByStartDateDesc(int courseid);
	List<CourseSchedule> findByCourse_courseIdIn(int[] courseId);
}
