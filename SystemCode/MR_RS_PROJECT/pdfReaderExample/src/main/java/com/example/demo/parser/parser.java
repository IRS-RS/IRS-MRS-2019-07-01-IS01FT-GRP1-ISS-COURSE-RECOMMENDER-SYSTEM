package com.example.demo.parser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class parser {
private String resume;
@Autowired
keyskillKB kb;
@Autowired
keyPositions kp;

public String getResume() {
	return resume;
}

public void setResume(String resume) {
	this.resume = resume;
}

public parser(String resume) {
	this.resume=resume;
	
}

public parser() {
	
}

public String getName() {
	return resume.substring(0,resume.indexOf('\n'));
}
public String getEmail() {
	Pattern p=Pattern.compile("[a-z][a-z0-9_]*@[a-z]*[a-z\\.]*",Pattern.CASE_INSENSITIVE);
	Matcher m=p.matcher(resume.toString().toLowerCase());
	if(m.find())
	{
		return m.group();
	}
	else {
		return "";
		
	}
}

public int getWorkExperience() {
	Pattern p=Pattern.compile("[0-9][0-9][0-9][0-9]",Pattern.CASE_INSENSITIVE);
	Matcher m=p.matcher(resume.toString());
	int experience=resume.toLowerCase().indexOf("experience");
	if(experience!=-1)
	{
	int year=Calendar.getInstance().get(Calendar.YEAR);
	int i=0;
	List<Integer> exp=new ArrayList<Integer>();
	if(resume.toLowerCase().indexOf("present")!=-1||resume.toLowerCase().indexOf("current")!=-1)
	{
		if(resume.toLowerCase().indexOf("present")>experience||resume.toLowerCase().indexOf("current")>experience)
		{
			exp.add(year);
		}
		
	}
	while(m.find())
	{
		if(((year-Integer.parseInt(m.group()))<=50 || (Integer.parseInt(m.group())-year)<=6) && m.start()>experience &&i<=8){
	    exp.add(Integer.parseInt(m.group()));
		i++;
		}
	}
	if(exp.size()>1)
	{
	return(Collections.max(exp)-Collections.min(exp));
	}
	else {
		return 0;
		
	}
	
	}
	else {
		return 0;
		
	}
	
	}

public String getKP() {
	int experience=resume.toLowerCase().indexOf("experience");
	String keyp=new String();
	HashMap<String,String[]> map=kp.getMap();
	String data=resume.toLowerCase().substring(experience);
	for(Map.Entry m:map.entrySet()) {
		for(String s:map.get(m.getKey())) {
			if(data.indexOf(s)!=-1 && keyp.indexOf((String)m.getKey())==-1)
			{
				if(keyp.isEmpty())
				{
					keyp=(String)m.getKey();
				}
				else {
					keyp=keyp+","+(String)m.getKey();
				}
			}
		   }
		
	}
	System.out.println(keyp);
	return keyp;
}

public String getKPS(String res) {
	String keyp=new String();
	HashMap<String,String[]> map=kp.getMap();
	String data=res.toLowerCase();
	for(Map.Entry m:map.entrySet()) {
		for(String s:map.get(m.getKey())) {
			if(data.indexOf(s)!=-1 && keyp.indexOf((String)m.getKey())==-1)
			{
				if(keyp.isEmpty())
				{
					keyp=(String)m.getKey();
				}
				else {
					keyp=keyp+","+(String)m.getKey();
				}
			}
		   }
		
	}
	System.out.println(keyp);
	return keyp;
}

public String getSkills() {
	String kp=new String();
	HashMap<String,String[]> map=kb.getMap();
	String data=resume.toLowerCase();
	for(Map.Entry m:map.entrySet()) {
		for(String s:map.get(m.getKey())) {
			if(data.indexOf(s)!=-1 && kp.indexOf((String)m.getKey())==-1)
			{
				if(kp.isEmpty())
				{
					kp=(String)m.getKey();
				}
				else {
					kp=kp+","+(String)m.getKey();
				}
			}
		   }
		
	}
	System.out.println(kp);
	return kp;
}

public String getSkillsS(String res) {
	String kp=new String();
	HashMap<String,String[]> map=kb.getMap();
	String data=res.toLowerCase();
	for(Map.Entry m:map.entrySet()) {
		for(String s:map.get(m.getKey())) {
			if(data.indexOf(s)!=-1 && kp.indexOf((String)m.getKey())==-1)
			{
				if(kp.isEmpty())
				{
					kp=(String)m.getKey();
				}
				else {
					kp=kp+","+(String)m.getKey();
				}
			}
		   }
		
	}
	System.out.println(kp);
	return kp;
}
public String getEducation() {
	Pattern p=Pattern.compile("^(phd .*)|(mtech .*)|(masters .*)|(bachelors .*)",Pattern.CASE_INSENSITIVE);
	Matcher m=p.matcher(resume.toString().toLowerCase());
	if(m.find())
	{
		return resume.substring(m.start(),m.end());
	}
	else {
		return null;
		}
	
}
	
}



