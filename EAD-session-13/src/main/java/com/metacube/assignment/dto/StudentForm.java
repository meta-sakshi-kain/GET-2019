package com.metacube.assignment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class StudentForm {

	@NotBlank(message = "{blankEmail}")
	@Size(min = 6, message = "{smallEmail}")
	@Size(max = 40, message = "{largeEmail}")
	private String email;

	@NotBlank(message = "{blankName}")
	@Size(min = 3, message = "{smallName}")
	@Size(max = 20, message = "{largeName}")
	@Pattern(regexp = "[A-z a-z]*", message = "{validName}")
	private String firstName;

	@NotBlank(message = "{blankName}")
	@Size(min = 3, message = "{smallName}")
	@Size(max = 20, message = "{largeName}")
	@Pattern(regexp = "[A-z a-z]*", message = "{validName}")
	private String lastName;

	@NotBlank(message = "{blankName}")
	@Size(min = 3, message = "{smallName}")
	@Size(max = 20, message = "{largeName}")
	@Pattern(regexp = "[A-z a-z]*", message = "{validName}")
	private String fatherName;

	@NotNull(message = "{blankClass}")
	@Pattern(regexp = "^[1-9]|1[0-2]$", message = "{validClass}")
	private String std;

	@NotNull(message = "{blankAge}")
	@Pattern(regexp = "^[5-9]|1[0-9]$", message = "{validAge}")
	private String age;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
