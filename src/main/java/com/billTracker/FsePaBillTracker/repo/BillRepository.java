package com.billTracker.FsePaBillTracker.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;
import com.billTracker.FsePaBillTracker.entitys.BillTrackerDetails;


public interface BillRepository extends CrudRepository<BillTrackerDetails, String>{

	void updateBill(BillTrackerDetails bil);

	void createBill(BillTrackerDetails bil);

}


	


