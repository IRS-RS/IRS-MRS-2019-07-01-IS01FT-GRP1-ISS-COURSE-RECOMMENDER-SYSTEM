package com.example.demo.ExamFee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamFeeService {
	@Autowired 
	examFeeRepo repo;
	
	public List<ExamFee> getAll() {
		List<ExamFee> ef=new ArrayList<ExamFee>();
		repo.findAll().forEach(ef::add);
		return ef;
	}
	
	public List<ExamFee> getByCourse(int CourseId) {
		List<ExamFee> ef=new ArrayList<ExamFee>();
		repo.findByCourse_courseId(CourseId).forEach(ef::add);
		return ef;
	}
	
	
	

}
