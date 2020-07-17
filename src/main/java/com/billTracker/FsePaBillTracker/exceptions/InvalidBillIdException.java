package com.billTracker.FsePaBillTracker.exceptions;

public class InvalidBillIdException extends RuntimeException {
	
	public InvalidBillIdException() {
		super("Invalid BillId");
	}

}
