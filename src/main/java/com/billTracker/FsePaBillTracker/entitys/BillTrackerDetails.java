package com.billTracker.FsePaBillTracker.entitys;
	


import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Entity
@Table(name="Billess")
@Data
public class BillTrackerDetails {

			@Id
			private Long  Id;	
			private String title;
			private String category;
			private String dateOfEntry;
			private String dueDate;
			private double amount;
			private String pad;
			private String unpad;
		}
