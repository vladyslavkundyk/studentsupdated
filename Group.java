package com.students.groupsofstudents;

import java.util.Comparator;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Group {

	private String groupName;
//	private Student[] students;
	private List<Student> students = new ArrayList<>(10);

	public Group() {
	}

	public Group(String groupName) {
		super();
//		students = new Student[10];
		this.groupName = groupName;
	}

	public Group(String groupName, List<Student> students) {
		this.groupName = groupName;
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// OLD Method for adding a student to a group. In case of adding 11 students
	// a custom exception must be thrown:

//	public void addStudent(Student student) throws GroupOverflowException {
//
//		for (int i = 0; i < students.length; i++) {
//			if (students[i] == null) {
//				students[i] = student;
////				System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
////						+ " added to group " + student.getGroupName() + "!");
//				return;
//			}
//		}

	// NEW Method for adding a student to a group. In case of adding 11 students
	// a custom exception must be thrown:

	public void addStudent(Student student) throws GroupOverflowException {

		if (students.size() < 10) {
			students.add(student);
			student.setGroupName(this.groupName);
			student.setId(students.size());
			return;
		}
		throw new GroupOverflowException("Student " + student.getLastName() + " not added,\ngroup is full!");
	}

	// OLD Method of searching for a student in a group. If the student is not found
	// a custom exception must be thrown:

//	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
//
//		for (int j = 0; j < students.length; j++) {
//			if (students[j] != null) {
//				if (students[j].getLastName() == lastName) {
//					return students[j];
//				}
//			}
//		}
//		throw new StudentNotFoundException("Student not found,\nor he has not yet been added to the group!");
//	}

	// NEW Method of searching for a student in a group. If the student is not found there
	// a custom exception must be thrown:

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		Student tempStudent = null;

		for (Student student : students) {
			if (student.getLastName().equals(lastName)) {
				tempStudent = student;
			}
		}
		if (tempStudent == null) {
			throw new StudentNotFoundException(
					"Student by last name " + lastName + " not found,\nor he has not yet been added to the group!\n");
		}
		System.out.println("Student by last name found! It:");
		return tempStudent;
	}

	// OLD Method for deleting a student by id,
	// return true if a student existed and was removed, false otherwise:

//	public boolean removeStudentById(int id) {
//
//		for (int k = 0; k < students.length; k++) {
//			if (students[k] != null) {
//				if (students[k].getId() == id) {
//					students[k] = null;
//					System.out.println("Student by id " + id + " removed!");
//					return true;
//				}
//			}
//		}
//		System.out.println("Student by id " + id + " not found!");
//		return false;
//	}

	// NEW Method for deleting a student by id,
	// return true if a student existed and was removed, false otherwise:

	public boolean removeStudentById(int id) {

		for (Student student : students) {
			if (student.getId() == id) {
				System.out.println("Student by id " + id + " removed!");
				students.remove(student);
				return true;
			}
		}
		System.out.println("Student by id " + id + " not found!\n");
		return false;
	}

	// OLD Method for sorting an array of students by last name:

//	public void sortStudentsByLastName() {
//		Arrays.sort(students, Comparator.nullsFirst(new StudentsLastNameComparator()));
//	}

	// NEW Method for sorting an array of students by last name:

	public void sortStudentsByLastName() {
		Collections.sort(students, Comparator.comparing(Human::getLastName));
	}

	// OLD Method for checking the fact that there are no equivalent students in a group:

//	public boolean checkStudentsSimilarity() {
//		for (int i = 0; i < students.length; i++) {
//			for (int j = i + 1; j < students.length; j++) {
//				if (students[i] != null && students[j] != null) {
//					if (students[i].equals(students[j])) {
//						System.out.println("Similar student found: " + students[i].getName() + " "
//								+ students[i].getLastName());
//						return true;
//
//					}
//				}
//			}
//		}
//		System.out.println("Similar students not found!");
//		return false;
//	}

	// NEW Method for checking the fact that there are no equivalent students in the group:

	public boolean checkStudentsSimilarity() {
		for (int i = 0; i < students.size() - 1; i++) {
			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(i).getLastName() != null && students.get(i).getName() != null
						&& students.get(j).getLastName() != null && students.get(j).getName() != null
						&& students.get(i).getLastName().equals(students.get(j).getLastName())
						&& students.get(i).getName().equals(students.get(j).getName())) {

					System.out.println("Similar student found: " + students.get(i).getName() + " "
							+ students.get(i).getLastName());
					return true;
				}
			}
		}
		System.out.println("Similar students not found!");
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

	// OLD Student group output method:

//	@Override	
//	public String toString() {
//		String listOfStudents = "";
//		String[] arrayOfStudents = new String[10];
//
//		for (int i = 0; i < arrayOfStudents.length; i++) {
//			if (students[i] != null)
//				arrayOfStudents[i] = students[i].getLastName() + " " + students[i].getName();
//			else
//				arrayOfStudents[i] = "";
//		}
//
//		Arrays.sort(arrayOfStudents);
//		for (int i = 0; i < arrayOfStudents.length; i++) {
//			if (arrayOfStudents[i] != "") {
//				listOfStudents += arrayOfStudents[i] + "\n";
//			}
//		}
//
//		return listOfStudents;
//	}

	// NEW Student group output method:

	@Override
	public String toString() {
		sortStudentsByLastName();
		StringBuilder studentsList = new StringBuilder("Group information: " + groupName + '\n');

		for (Student student : students) {
			studentsList.append(student.toString());
		}
		return studentsList.toString();
	}
}
