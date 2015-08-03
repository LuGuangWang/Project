package com.main.util.test;

import java.util.Date;
import java.util.List;


public class Bean {
	private List<String> studentCodes;
	private String schoolId;
	private List<String> classCodes;
	private Date currentDay;
	public List<String> getStudentCodes() {
		return studentCodes;
	}
	public void setStudentCodes(List<String> studentCodes) {
		this.studentCodes = studentCodes;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public List<String> getClassCodes() {
		return classCodes;
	}
	public void setClassCodes(List<String> classCodes) {
		this.classCodes = classCodes;
	}
	public Date getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(Date currentDay) {
		this.currentDay = currentDay;
	}
}
