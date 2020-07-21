package com.billTracker.FsePaBillTracker.entitys;
	


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



import lombok.Data;
@Entity
@Table(name="Billess")
@Data
public class BillTrackerDetails {

			@javax.persistence.Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long  Id;	
			private String title;
			private String category;
			private String dateOfEntry;
			private String dueDate;
			private double amount;
			private String pad;
			private String unpad;
		}
