package com.billTracker.FsePaBillTracker.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;
import com.billTracker.FsePaBillTracker.entitys.BillTrackerDetails;

@Repository
public interface BillRepository extends CrudRepository<BillTrackerDetails, Long>{

	

}


	


