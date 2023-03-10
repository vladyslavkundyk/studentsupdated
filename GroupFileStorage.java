package com.students.groupsofstudents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GroupFileStorage {

	CSVStringConverter convert = new CSVStringConverter();

	// OLD:

//	public void saveGroupToCSV(Group group) {
//
//		File fileGroupName = new File("D:\\Groups of students\\" + group.getGroupName() + ".csv");
//
//		try (PrintWriter pw = new PrintWriter(fileGroupName)) {
//			for (int i = 0; i < group.getStudents().length; i++) {
//				Student student = group.getStudents()[i];
//				if (student != null) {
//					pw.println(convert.toStringRepresentation(student));
//				}
//			}
//			System.out.println("Group saved to file: " + group.getGroupName() + ".csv");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	// NEW:

	public void saveGroupToCSV(Group group) {

		File file = new File("D:\\Groups of students\\" + group.getGroupName() + ".csv");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (Student i : group.getStudents()) {
				if (i != null) {
					bw.write(new CSVStringConverter().toStringRepresentation(i));
					bw.newLine();
				}
			}
			System.out.println("Group saved to file: " + group.getGroupName() + ".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Group loadGroupFromCSV(File file) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String tempString = "";
			Group tempGroup = new Group(file.getName());
			for (;;) {
				tempString = br.readLine();
				if (tempString == null) {
					break;
				}
				try {
					tempGroup.addStudent(convert.fromStringRepresentation(tempString));
				} catch (GroupOverflowException e) {
					e.printStackTrace();
				}
			}
			return tempGroup;
		}
	}

	public File findFileByGroupName(String groupName, File workFolder) {

		File[] tempFiles = workFolder.listFiles();
		if (tempFiles != null) {
			for (int i = 0; i < tempFiles.length; i++) {
				if (tempFiles[i].isFile() && tempFiles[i].getName().equals(groupName + ".csv")) {
					return tempFiles[i];
				}
			}
		}
		return null;
	}
}
