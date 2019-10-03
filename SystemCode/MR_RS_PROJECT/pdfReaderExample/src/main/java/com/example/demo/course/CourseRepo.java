package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course,Integer> {
	public Optional<Course> findOneByCourseName(String courseName);
	public List<Course> findAllByCourseName(String courseName);
	public Optional<Course> findOneByDuration(String Duration);
	public List<Course> findAllByDuration(String duration);
	public List<Course> findAllByparentCourse_id(int id);
	public Optional<Course> findOneByReference(String reference);
	public List<Course> findAllByReference(String reference);
	public List<Course> findByIntroductionContaining(String introduction);
	public List<Course> findBytopicCoveredContaining(String topicCovered);
	public List<Course> findBytakeAwayContaining(String takeAway);
	public List<Course> findByCourseIdIn(int[] courseid);
}

