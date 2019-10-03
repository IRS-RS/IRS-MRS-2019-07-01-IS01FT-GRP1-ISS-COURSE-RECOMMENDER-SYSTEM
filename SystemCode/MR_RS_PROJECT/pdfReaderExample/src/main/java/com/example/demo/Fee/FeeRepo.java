package com.example.demo.Fee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FeeRepo extends CrudRepository<Fee,Integer> {

	List<Fee> findById(int id);
	List<Fee> findByCourse_courseId(int courseId);
	
}
