package com.billTracker.FsePaBillTracker.service;

import java.util.List;

import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;

public interface BillService {
	public List<BillTrackerDetailsDTO> getAllBilles();
	public Long updateBill(BillTrackerDetailsDTO bill);	
	public BillTrackerDetailsDTO addBill(BillTrackerDetailsDTO bill);
	public BillTrackerDetailsDTO deleteBill(BillTrackerDetailsDTO bill);
	public BillTrackerDetailsDTO createBill(BillTrackerDetailsDTO bill);
}





