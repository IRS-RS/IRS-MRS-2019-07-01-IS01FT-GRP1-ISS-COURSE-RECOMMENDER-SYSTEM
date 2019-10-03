package com.example.demo.Fee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeService {

	@Autowired
	FeeRepo repo;
	
	public List<Fee> getAll() {
		List<Fee> fee = new ArrayList<Fee>();
		repo.findAll().forEach(fee::add);
		return fee;
	}
	
	public List<Fee> getAllByCourseId(int courseId) {
		List<Fee> fee = new ArrayList<Fee>();
		repo.findByCourse_courseId(courseId).forEach(fee::add);
		return fee;
	}
	
}
