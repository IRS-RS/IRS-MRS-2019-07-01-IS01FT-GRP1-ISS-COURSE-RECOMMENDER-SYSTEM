package com.example.demo.opta;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class ScheduleAssignment {
	private List<courseSlots> course_Slots;
	private List<courseSchedule> courseSchedule;
	private HardSoftScore score;
	@ValueRangeProvider(id="courseSlot")
	@ProblemFactCollectionProperty
	public List<courseSlots> getCourse_Slots() {
		return course_Slots;
	}
	public void setCourse_Slots(List<courseSlots> course_Slots) {
		this.course_Slots = course_Slots;
	}
	@PlanningEntityCollectionProperty
	public List<courseSchedule> getCourseSchedule() {
		return courseSchedule;
	}
	public void setCourseSchedule(List<courseSchedule> courseSchedule) {
		this.courseSchedule = courseSchedule;
	}
	@PlanningScore
	public HardSoftScore getScore() {
		return score;
	}
	public void setScore(HardSoftScore score) {
		this.score = score;
	}
	
	
}
