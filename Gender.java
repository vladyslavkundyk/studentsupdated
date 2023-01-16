package com.students.groupsofstudents;

public enum Gender {

	Male("He is a student "), Female("She is a student ");

	private String getFilePermissions = "";

	private Gender(String getFilePermissions) {
		this.getFilePermissions = getFilePermissions;
	}

	public String getFilePermissions() {
		return getFilePermissions;
	}

	public void setFilePermissions(String getFilePermissions) {
		this.getFilePermissions = getFilePermissions;
	}
}
