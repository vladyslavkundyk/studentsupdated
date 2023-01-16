package com.students.groupsofstudents;

import java.util.Scanner;
import java.util.Random;

public class CreateStudent {

	Scanner sc = new Scanner(System.in);
	Random rannum = new Random();

	public Student newStudent() {

		Student student = new Student(null, null, null, 0, null);

		System.out.println("Enter student name (String) >");
		student.setName(sc.nextLine());

		System.out.println("Enter student last name (String) >");
		student.setLastName(sc.nextLine());

		System.out.println("Enter student gender (male/female) >");
		String studentGender = sc.nextLine();

		if (studentGender.equals("male")) {
			student.setGender(Gender.Male);
		} else if (studentGender.equals("female")) {
			student.setGender(Gender.Female);
		} else {
			System.out.println("");
			System.out.println("Wrong input!");
			System.out.println("");
		}

//		student.setId(rannum.nextInt(200, 500));
//		System.out.println("Student id " + student.getId() + " generated!");
//		System.out.println("");

//		System.out.println("Enter the name of the student group (String) >");
//		student.setGroupName(sc.nextLine());

		return student;
	}

	public static void addStudentToGroup(Student student, Group group) {

		try {
			group.addStudent(student);
		} catch (GroupOverflowException e) {
			System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
					+ " not added,\ncurrent group is full!");
		}
	}
}
