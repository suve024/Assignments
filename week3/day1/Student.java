package org.student;

import org.department.Department;

public class Student extends Department{
	public void studentName() {
		System.out.println("Student name is Thara");
	}

	public void studentDept() {
		System.out.println("Department IT");
	}
	
	public void studentId() {
		System.out.println("ID : 5");
	}
	public static void main(String[] args) {
		Student s = new Student();
		s.collegeName();
		s.collegeCode();
		s.collegeRank();
		s.deptName();
		s.studentName();
		s.studentId();
		s.studentDept();
	}

}
