package com.example.demo.ExamFee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface examFeeRepo extends CrudRepository<ExamFee,Integer> {
	List<ExamFee> findById(int id);
	List<ExamFee> findByCourse_courseId(int id);
}
