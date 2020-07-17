package com.billTracker.FsePaBillTracker.exceptions;

public class InvalidBillStatusException extends RuntimeException {
	public InvalidBillStatusException() {
		super("No such status exists");
	}

}
