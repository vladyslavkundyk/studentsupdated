package com.students.groupsofstudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		
		SpringApplication.run(Main.class, args);

		Student student1 = new Student("Jodie", "Berg", Gender.Male, 0, "");
		Student student2 = new Student("Myles", "Harvey", Gender.Male, 0, "");
		Student student3 = new Student("Melvin", "Dawson", Gender.Male, 0, "");
		Student student4 = new Student("Gerard", "Bradford", Gender.Male, 0, "");
		Student student5 = new Student("Robbie", "Peters", Gender.Male, 0, "");
		Student student6 = new Student("Clara", "Kaufman", Gender.Female, 0, "");
		Student student7 = new Student("Herbie", "Johns", Gender.Male, 0, "");
		
		Student student10 = new Student("Clara", "Kaufman", Gender.Female, 0, "");

		Group group1 = new Group("Main");

		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
//			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);

		} catch (GroupOverflowException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		try {
			System.out.println(group1.searchStudentByLastName("Kaufman"));
			System.out.println(group1.searchStudentByLastName(student5.getLastName())); // Does not exist
			System.out.println();

		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		group1.removeStudentById(group1.getStudents().size()); // Delete last student
		group1.removeStudentById(491); // Does not exist

		// SortStudentsByLastName, create student
//		System.out.println();
//		System.out.println("Creating a new student:");
//		System.out.println();
//		Student student30 = new CreateStudent().newStudent();
//		CreateStudent.addStudentToGroup(student30, group1);
//
//		System.out.println();
//		System.out.println("Information about the created student:");
//		System.out.println();
//		System.out.println(student30);

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		group1.sortStudentsByLastName();
		System.out.println("Group of students " + group1.getGroupName() + " sorted!");
		System.out.println();
		System.out.println(group1);

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		// Saving a group to a CSV file
		GroupFileStorage gfs = new GroupFileStorage();
		gfs.saveGroupToCSV(group1);
		System.out.println();
		
		// Finding a file in the working directory
//		File groupsFolder = new File("D:\\Groups of students");
//		String groupToSearch = ("Main");
//		File searchGroup = gfs.findFileByGroupName(groupToSearch, groupsFolder);
//		if (searchGroup != null) {
//			System.out.println("Group file found: " + searchGroup.getName());
//			System.out.println();
//		} else {
//			System.out.println("Group" + groupToSearch + " does not exist!");
//		}
//
		// Reading and returning a group from a file
//		String groupToLoad = "Main";
//		File groupsDirectory = new File("D:\\Groups of students\\" + groupToLoad + ".csv");
//		Group tempGroup = new Group("");
//		try {
//			tempGroup = gfs.loadGroupFromCSV(groupsDirectory);
//		} catch (FileNotFoundException e) {
//			System.out.println("File with a group " + groupToLoad + ".csv does not exist!");
//		} catch (IOException b) {
//			b.printStackTrace();
//		}
//
		// Reading and returning another group from a file
//		groupToLoad = "Additional";
//		groupsDirectory = new File("D:\\Groups of students\\" + groupToLoad + ".csv");
//		try {
//			tempGroup = gfs.loadGroupFromCSV(groupsDirectory);
//		} catch (FileNotFoundException e) {
//			System.out.println("File with a group " + groupToLoad + ".csv does not exist!");
//		} catch (IOException b) {
//			b.printStackTrace();
//		}
//
//		System.out.println("Students from group file " + tempGroup.getGroupName() + ":");
//		System.out.println();
//		System.out.println(tempGroup);

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		System.out.println("Student 1 equals student 2 = " + student2.equals(student1));
		System.out.println("Student 2 equals student 3 = " + student2.equals(student3));
		System.out.println("Student 2 equals student 2 = " + student2.equals(student2));
		System.out.println();

		System.out.println(student1.getName() + " " + student1.getLastName() + " - hashCode = " + student1.hashCode());
		System.out.println(student2.getName() + " " + student2.getLastName() + " - hashCode = " + student2.hashCode());
		System.out.println(student3.getName() + " " + student3.getLastName() + " - hashCode = " + student3.hashCode());
		System.out.println();

		System.out.println("+---+---+---+---+---+---+---+");
		System.out.println();

		group1.checkStudentsSimilarity();
//		System.out.println(group1.checkStudentsSimilarity());
		System.out.println();

		try {
			group1.addStudent(student10);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}

		group1.checkStudentsSimilarity();
//		System.out.println(group1.checkStudentsSimilarity());
		System.out.println();

		System.out.println("+---+---+---+---+---+---+---+");
	}
}
