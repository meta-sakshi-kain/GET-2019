package com.metacube.EADHIBERNATEASSIGNMENT2.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
//class for search student by class page
public class Standard {
	@NotNull(message = "{blankStd}")
	@Min(1)
	@Max(12)
	private int std;

	public Standard() {
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}
}
