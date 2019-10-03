package com.example.demo;

import java.io.File;

import com.example.demo.course.Course;
import com.example.demo.course.courseService;
import com.example.demo.courseSchedule.CourseSchedule;
import com.example.demo.courseSchedule.CourseScheduleService;
import com.example.demo.opta.ScheduleAssignment;
import com.example.demo.opta.courseSchedule;
import com.example.demo.opta.problemInitializer;
import com.example.demo.parser.parser;
import com.example.demo.parser.userinfo;
import com.example.demo.ExamFee.ExamFee;
import com.example.demo.ExamFee.ExamFeeService;
import com.example.demo.Fee.Fee;
import com.example.demo.Fee.FeeService;
import com.example.demo.ParentCourse.ParentCourseService;
import com.example.demo.ParentCourse.ParentCourse;

import com.example.demo.readers.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class PDFController {
	@Autowired 
	PdfReader pdf;
	
	@Autowired
	WordReader word;
	
	@Autowired
	courseService course;
	
	@Autowired
	ParentCourseService parentCourse;
	
	@Autowired
	CourseScheduleService courses;
	
	@Autowired 
	ExamFeeService exam;
	
	@Autowired
	FeeService fee;
	
	@Autowired
	userinfo u;
	
	@Autowired
	parser p;
	
	@Autowired
	Service rs;
	
	
	@RequestMapping("/home")
	public String Home() {
		u.resetDefault();
		return "home";	
	}
	
	@RequestMapping("/response")
	public ModelAndView response(@RequestParam("file") MultipartFile file) {
		System.out.println("File response obtained..."+file.getOriginalFilename()+" "+file.getSize());		
		String filename= file.getOriginalFilename();
		int fileIndex=filename.lastIndexOf('.');
		String extension=filename.substring(fileIndex+1);
		String text="";
		System.out.println("Is file empty:"+file.getContentType());
		if(extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("docx")) {
			System.out.println("Getting the word reader");
			try {
			byte[] b = file.getBytes();	
			Path path =Paths.get(file.getOriginalFilename());
			Files.write(path, b);
			File f1=new File(file.getOriginalFilename());
			text = word.getText(f1);
			f1.deleteOnExit();
			if(f1.delete())
			{
				System.out.println("The choosen file seems to be deleted");
				
			}
			else {
				System.out.println("The file could not be deleted");
				
			}
			}
			catch(FileSizeLimitExceededException e)
			{
				text="File Size Exceeded";	
			}
			catch(Exception e)
			{
				e.printStackTrace();
				text="Unable to open file";
			}
			}
		else if(extension.equalsIgnoreCase("pdf")) {
			System.out.println("Getting the pdf reader");
			try {
				byte[] b = file.getBytes();	
				Path path =Paths.get(file.getOriginalFilename());
				Files.write(path, b);
				File f1=new File(file.getOriginalFilename());
				text = pdf.getText(f1);
				f1.deleteOnExit();
				if(f1.delete())
				{
					System.out.println("The choosen file seems to be deleted");
					
				}
				else {
					System.out.println("The file could not be deleted");
					
				}
			}
			catch(FileSizeLimitExceededException e)
			{
				e.getStackTrace();
				text="File Size Exceeded";	
			}
			catch(Exception e) {
				e.printStackTrace();
				text="Unable to open file";
			}
		}
		else {
			System.out.println("Unsupported file formats");
			text ="Unsupported file formats";
		}
		if(!(text.equalsIgnoreCase("Unsupported file formats")||text.equalsIgnoreCase("Unable to open file")||text.equalsIgnoreCase("File Size Exceeded")))
		{
			p.setResume(text.trim());
			u.setName(p.getName());
			u.setEmail(p.getEmail());
			u.setWorkExperience(p.getWorkExperience());
			u.setTechnicalSkills(p.getSkills());
			u.setKeyPositions(p.getKP());
			u.setDegree(p.getEducation());
		}
		System.out.println("File Extension:"+extension);
		ModelAndView mv=new ModelAndView("CoursePages");
		//mv.addObject("status",text);
		/*
		 * Add code for putting the data into user-info
		 * */	
		List<ParentCourse> l =  parentCourse.getAll();
		mv.addObject("course",l);
		return mv;	
	}
	
	@RequestMapping("/ParentCourse")
	public ModelAndView GetParentCourse() {
		ModelAndView mv=new ModelAndView("CoursePages");
		List<ParentCourse> l =  parentCourse.getAll();
		mv.addObject("course",l);
		return mv;	
	}
	
	@RequestMapping("/details")
	public ModelAndView DisplayCourses(@RequestParam("options") int options) {
		ModelAndView mv=new ModelAndView("personalinfo");
		System.out.println(options);
		List<Course> c=course.getByParentCourse(options);
		//Adding the requested career path to the user's profile
		u.setCareerPath(options);
		//mv.addObject("CourseList",c);
		mv.addObject("user",u);
		return mv;
	}
	
	private String getFeeC(String f,int id){
		List<Fee> f1=fee.getAllByCourseId(id);
		
		Fee fee_s=f1.get(0);
		
		String s=new String();
		switch(f) {
		case "FPS":
			s="$"+fee_s.getCFIP();
			break;
		case "FPCS":
			s="$"+fee_s.getCFIPC();
			break;
		case "PRS":
			s="$"+fee_s.getSFPC();
			break;
		case "PRCS":
			s="$"+fee_s.getCFPC();
			break;
		case "SFMCES":
			s="$"+fee_s.getSFSFMCESC();
			break;
		case "WTS":
			s="$"+fee_s.getSFWTSC();
			break;
		case "CWTS":
			s="$"+fee_s.getCFWTSC();
			break;
		case "CSFMCES":	
			s="$"+fee_s.getCFSFMCESC();
			break;
		}	
		System.out.println(s);
		return s;	
		}
	
	private String getFeeNC(String f,int id){
	List<Fee> f1=fee.getAllByCourseId(id);
	
	Fee fee_s=f1.get(0);
	
	
	String s=new String();
	switch(f) {
	case "FPS":
		s="$"+fee_s.getSFIP();
		break;
	case "FPCS":
		s="$"+fee_s.getCFIP();
		break;
	case "PRS":
		s="$"+fee_s.getSFP();
		break;
	case "PRCS":
		s="$"+fee_s.getCFP();
		break;
	case "SFMCES":
		s="$"+fee_s.getSFSFMCES();
		break;
	case "WTS":
		s="$"+fee_s.getSFWTS();
		break;
	case "CWTS":
		s="$"+fee_s.getCFWTS();
		break;
	case "CSFMCES":	
		break;
	}	
	return s;	
	}
	
	private String getExamFee(String method,int courseid) {
		String ef=new String();
		List<ExamFee> efe=exam.getByCourse(courseid);
		ExamFee e=efe.get(0);
		if(method=="Self")
			ef="S$"+e.getExamfeeself();
		else
			ef="S$"+e.getExamfeecs();
		return ef;
		
	}
	
	@RequestMapping("/recommendCourses")
	public ModelAndView RecommendCourses(@RequestParam("firstname") String fname,
			@RequestParam("Nationality") String Nationality,
			@RequestParam(value="Key Positions Held",required=false) String kp,
			@RequestParam("fee") String fee,
			@RequestParam(value ="Subsidry",required=false) String Subsidary,
			@RequestParam(value="Work Experience",required=false) int we,
			@RequestParam(value="Technical Skills",required=false) String te,
			@RequestParam(value="Degree Held",required=false) String degree,
			@RequestParam(value="email",required=false) String email) {
		String name =fname;
		System.out.println("Nationality:"+Nationality+" "+"fee:"+fee+" Subsidry:"+Subsidary);
		String f=new String();
		if(Nationality.equalsIgnoreCase("Foriegner") && fee.equalsIgnoreCase("Self")) {
			f="FPS";
			u.setFee("FPS");
		}
		else if (Nationality.equalsIgnoreCase("Foriegner") && fee.equalsIgnoreCase("CS"))
		{
			f="FPCS";
			u.setFee("FPCS");
		}
		else if(Nationality.equalsIgnoreCase("PR") && fee.equalsIgnoreCase("Self")) {
			f="PRS";
			u.setFee("PRS");
		}
		else if(Nationality.equalsIgnoreCase("PR") && fee.equalsIgnoreCase("CS"))
		{
			f="PRCS";	
			u.setFee("PRCS");
		}
		else if(Nationality.equalsIgnoreCase("Citizen") && fee.equalsIgnoreCase("Self") &&(Subsidary==null||Subsidary.isEmpty()))
		{
			f="PRS";	
			u.setFee("PRS");
		}
		else if(Nationality.equalsIgnoreCase("Citizen") && fee.equalsIgnoreCase("CS") && (Subsidary==null||Subsidary.isEmpty()))
		{
			f="PRCS";	
			u.setFee("PRCS");
		}
		else if(Nationality.equalsIgnoreCase("Citizen") && fee.equalsIgnoreCase("Self") && Subsidary.equalsIgnoreCase("SFMCES"))
		{
			f="SFMCES";	
			u.setFee("SFMCES");
		}
		else if(Nationality.equalsIgnoreCase("Citizen") && fee.equalsIgnoreCase("Self") && Subsidary.equalsIgnoreCase("WTS")) {
			f="WTS";
			u.setFee("WTS");
		}
		else if(Nationality.equalsIgnoreCase("Citizen") && fee.equalsIgnoreCase("CS") && Subsidary.equalsIgnoreCase("WTS")) {
			f="CWTS";
			u.setFee("CWTS");
		}
		else if(Nationality.equalsIgnoreCase("Citizen") && fee.equalsIgnoreCase("CS") && Subsidary.equalsIgnoreCase("CSFMCES")) {
			f="CSFMCES";
			u.setFee("CSFMCES");
		}
		System.out.println("fees:"+f+" "+u.getFee());
		u.setName(name);
		u.setFee(f);
		if(email!=null &&  !email.isEmpty())
		u.setEmail(email);
		if(kp!=null &&  !kp.isEmpty())
		{
		u.setKeyPositions(p.getKPS(kp));
		}
		if(te!=null &&  !te.isEmpty())
		{
		u.setTechnicalSkills(p.getSkillsS(te));
		}
		u.setWorkExperience(we);
		if(degree!=null &&  !degree.isEmpty())
		{
			u.setDegree(degree);
		}
		//List<String> courses=new ArrayList<String>();
		
		int rules=rs.fireRules(u);
		System.out.println("Number of rules fired!!"+rules);
		int careerPath = u.getCareerPath();
		List<Course> c=new ArrayList<Course>();
		List<String> feenc=new ArrayList<String>();
		List<String> feec=new ArrayList<String>();		
		List<String> ef=new ArrayList<String>();
		int coursenums = u.getCourses().size();
		if(coursenums==0)
		{
		if(careerPath!=10) 
		{
			c=course.getByParentCourse(careerPath);
			for(int i=0;i<c.size();i++)
			{
				Course c1=c.get(i);
				feenc.add(getFeeNC(u.getFee(),c1.getCourseId()));
				feec.add(getFeeC(u.getFee(),c1.getCourseId()));
				ef.add(getExamFee(fee,c1.getCourseId()));
			}
		}
		else {
			c=course.getAllCourse();
			for(int i=0;i<c.size();i++)
			{
				Course c1=c.get(i);
				feenc.add(getFeeNC(u.getFee(),c1.getCourseId()));
				feec.add(getFeeC(u.getFee(),c1.getCourseId()));
				ef.add(getExamFee(fee,c1.getCourseId()));
			}
		}
	}
		else {
			int[] courses=u.getCourses().stream().filter(t->t!=null).mapToInt(t->t).toArray();
			c=course.getByCourseIdin(courses);
			for(int i=0;i<c.size();i++)
			{
				Course c1=c.get(i);
				feenc.add(getFeeNC(u.getFee(),c1.getCourseId()));
				feec.add(getFeeC(u.getFee(),c1.getCourseId()));
				ef.add(getExamFee(fee,c1.getCourseId()));
			}
		}
		ModelAndView mv=new ModelAndView("recommendCourses");
		mv.addObject("courses",c);
		mv.addObject("feenc",feenc);
		mv.addObject("feec",feec);
		mv.addObject("ef",ef);
		return mv;		
	}
	
	@RequestMapping("/scheduleCourses")
	public ModelAndView scheduleCourses(@RequestParam("checkbox") int[] checkbox)
	{	
		List<Course> c=new ArrayList<Course>();
		List<CourseSchedule> cs=new ArrayList<CourseSchedule>();
		c=course.getByCourseIdin(checkbox);
		cs=courses.getCSbyCourseId(checkbox);
		SolverFactory<ScheduleAssignment> solverFactory = SolverFactory.createFromXmlResource("com/example/solverConfiguration.xml");
		Solver<ScheduleAssignment> solver = solverFactory.buildSolver();
		ScheduleAssignment unsolved=new problemInitializer().getSpace(cs, c.size());
		ScheduleAssignment solvedProblem = solver.solve(unsolved);
		List<courseSchedule> cs_new=solvedProblem.getCourseSchedule();
		List<Integer> courseid=new ArrayList<Integer>();
		List<Integer> courseScheduleid=new ArrayList<Integer>();
		for(courseSchedule c1:cs_new) {
			if(c1.getSlot_no()!=null)
			{
				courseid.add(c1.getCourse());
				courseScheduleid.add(c1.getId());		
			}
		}
		c=course.getByCourseIdin(courseid.stream().filter(t->t!=null).mapToInt(t->t).toArray());
		cs=courses.getCSbyCourseId(courseScheduleid.stream().filter(t->t!=null).mapToInt(t->t).toArray());
		ModelAndView mv=new ModelAndView("courseSchedule");
		mv.addObject("course",c);
		mv.addObject("courseSchedule",cs);
		return mv;
	}
	
	
	
	
}
