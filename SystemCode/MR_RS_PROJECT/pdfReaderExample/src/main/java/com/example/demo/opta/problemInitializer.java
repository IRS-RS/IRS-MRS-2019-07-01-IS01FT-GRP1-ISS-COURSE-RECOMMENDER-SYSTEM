package com.example.demo.opta;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.courseSchedule.CourseSchedule;


public class problemInitializer {
	public problemInitializer() {
		
		
	}
	private void intializeCourseSlots(ScheduleAssignment sa,int numCourses) {
	List<courseSlots> i=new ArrayList<courseSlots>();
	for(int num=0;num<numCourses;num++)
	{
		courseSlots s=new courseSlots();
		s.setCourseSlots(num);	
		i.add(s);
	}
	sa.setCourse_Slots(i);
	}
	
	
	private void intializeCourseSchedule(ScheduleAssignment sa, List<CourseSchedule> sc) {
		List<courseSchedule> s1=new ArrayList<courseSchedule>();
		for(CourseSchedule s:sc)
		{
			courseSchedule courseS=new courseSchedule(s.getId(),s.getCourse().getCourseId(),s.getStartDate(),s.getEndTime());
			s1.add(courseS);
		}
		sa.setCourseSchedule(s1);
		
		
		
	}
	public ScheduleAssignment getSpace(List<CourseSchedule> sc,int numCourses)
	{
		ScheduleAssignment sa=new ScheduleAssignment();
		intializeCourseSchedule(sa,sc);
		intializeCourseSlots(sa,numCourses);
		return sa;
	}
}
