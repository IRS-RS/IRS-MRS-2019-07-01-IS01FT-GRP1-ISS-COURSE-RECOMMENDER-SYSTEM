package com.example.demo.ParentCourse;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ParentCourseRepo extends CrudRepository<ParentCourse,Integer> {
  List<ParentCourse> findById(int id);
  Optional<ParentCourse> findByName(String Course_Name);
  List<ParentCourse> findByCourse_courseId(int courseid);
  
  
}
