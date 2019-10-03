package com.example.demo.opta;

import java.sql.Date;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class courseSchedule {
	private int id;
	private Date startDate;
	private Date endTime;
	private int course;
	private courseSlots slot_no; 
	private int allocated=1;
	public int getAllocated() {
		return allocated;
		
	}
	public courseSchedule() {}
	public courseSchedule(int id,int course_course_id,Date startDate,Date endTime) {
		this.id=id;
		this.course=course_course_id;
		this.startDate=startDate;
		this.endTime=endTime;
	}
	@PlanningVariable(valueRangeProviderRefs = {"courseSlot"},nullable=true)
	public courseSlots getSlot_no() {
		return slot_no;
	}
	
	public void setSlot_no(courseSlots slot_no) {
		this.slot_no = slot_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
}
