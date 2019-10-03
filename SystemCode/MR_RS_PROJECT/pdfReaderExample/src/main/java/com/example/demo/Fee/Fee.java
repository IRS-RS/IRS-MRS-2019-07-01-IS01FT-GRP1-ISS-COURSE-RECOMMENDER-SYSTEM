package com.example.demo.Fee;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import org.springframework.stereotype.Component;
import com.example.demo.course.Course;
@Entity
@Component
public class Fee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne
	private Course course;
	private double SFIP;
	private double SFP;
	private double SFSFMCES;
	private double SFWTS;
	private double SFIPC;
	private double SFPC;
	private double SFSFMCESC;
	private double SFWTSC;
	private double CFIP;
	private double CFP;
	private double CFSFMCES;
	private double CFWTS;
	private double CFIPC;
	private double CFPC;
	private double CFSFMCESC;
	private double CFWTSC;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public double getSFIP() {
		return SFIP;
	}
	public void setSFIP(double sFIP) {
		SFIP = sFIP;
	}
	public double getSFP() {
		return SFP;
	}
	public void setSFP(double sFP) {
		SFP = sFP;
	}
	public double getSFSFMCES() {
		return SFSFMCES;
	}
	public void setSFSFMCES(double sFSFMCES) {
		SFSFMCES = sFSFMCES;
	}
	public double getSFWTS() {
		return SFWTS;
	}
	public void setSFWTS(double sFWTS) {
		SFWTS = sFWTS;
	}
	public double getSFIPC() {
		return SFIPC;
	}
	public void setSFIPC(double sFIPC) {
		SFIPC = sFIPC;
	}
	public double getSFPC() {
		return SFPC;
	}
	public void setSFPC(double sFPC) {
		SFPC = sFPC;
	}
	public double getSFSFMCESC() {
		return SFSFMCESC;
	}
	public void setSFSFMCESC(double sFSFMCESC) {
		SFSFMCESC = sFSFMCESC;
	}
	public double getSFWTSC() {
		return SFWTSC;
	}
	public void setSFWTSC(double sFWTSC) {
		SFWTSC = sFWTSC;
	}
	public double getCFIP() {
		return CFIP;
	}
	public void setCFIP(double cFIP) {
		CFIP = cFIP;
	}
	public double getCFP() {
		return CFP;
	}
	public void setCFP(double cFP) {
		CFP = cFP;
	}
	public double getCFSFMCES() {
		return CFSFMCES;
	}
	public void setCFSFMCES(double cFSFMCES) {
		CFSFMCES = cFSFMCES;
	}
	public double getCFWTS() {
		return CFWTS;
	}
	public void setCFWTS(double cFWTS) {
		CFWTS = cFWTS;
	}
	public double getCFIPC() {
		return CFIPC;
	}
	public void setCFIPC(double cFIPC) {
		CFIPC = cFIPC;
	}
	public double getCFPC() {
		return CFPC;
	}
	public void setCFPC(double cFPC) {
		CFPC = cFPC;
	}
	public double getCFSFMCESC() {
		return CFSFMCESC;
	}
	public void setCFSFMCESC(double cFSFMCESC) {
		CFSFMCESC = cFSFMCESC;
	}
	public double getCFWTSC() {
		return CFWTSC;
	}
	public void setCFWTSC(double cFWTSC) {
		CFWTSC = cFWTSC;
	}
	public Fee() {
		
		
	}
	
}
