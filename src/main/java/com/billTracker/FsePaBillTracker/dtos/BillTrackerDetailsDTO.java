package com.billTracker.FsePaBillTracker.dtos;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;



@Data
public class BillTrackerDetailsDTO {


    private Long Id;

	@Length(min = 5, max = 30)
	@NotNull
	private String title;

	@Length(min = 3, max = 25)
	@NotNull
	private String category;

	@Length(min = 3, max = 25)
	private double amount;

	@Length(min = 1, max = 25)
	private String pad;
	
	@Length(min = 1, max = 25)
	private String unpad;

	@NotNull
	private String dueDate;
	
	
	@NotNull
	private String dateOfEntry;
}
