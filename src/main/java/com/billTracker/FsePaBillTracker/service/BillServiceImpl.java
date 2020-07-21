package com.billTracker.FsePaBillTracker.service;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;
import com.billTracker.FsePaBillTracker.entitys.BillTrackerDetails;
import com.billTracker.FsePaBillTracker.repo.BillRepository;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository repository;

	@Override
	public List<BillTrackerDetailsDTO> getAllBilles() {
		
		List<BillTrackerDetailsDTO> bills = new ArrayList<BillTrackerDetailsDTO>();
			
		repository.findAll().forEach(bill -> {
			BillTrackerDetailsDTO billDTO = new BillTrackerDetailsDTO();
			//billDTO.setId(bill.getId());
			billDTO.setTitle(bill.getTitle());
			billDTO.setCategory(bill.getCategory());
			billDTO.setAmount(bill.getAmount());
			billDTO.setDateOfEntry(bill.getDateOfEntry());
			billDTO.setDueDate(bill.getDueDate());
			billDTO.setPad(bill.getPad());
			billDTO.setUnpad(bill.getUnpad());
			bills.add(billDTO);
		});
		
		return bills;
	}

	@Override
	public BillTrackerDetailsDTO addBill(BillTrackerDetailsDTO bill) {

		BillTrackerDetails bil = new BillTrackerDetails();
		//bil.setId(bill.getId());
		bil.setCategory(bil.getCategory());
		bil.setTitle(bill.getTitle());
		bil.setAmount(bill.getAmount());
		bil.setDateOfEntry(bill.getDateOfEntry());
		bil.setDueDate(bill.getDueDate());
		bil.setPad(bill.getPad());
		bil.setUnpad(bill.getUnpad());
		repository.save(bil);
		return bill;
	}

	@Override
	public BillTrackerDetailsDTO deleteBill(BillTrackerDetailsDTO bill) {
		BillTrackerDetails bil = new BillTrackerDetails();
		//bil.setId(bill.getId());
		bil.setCategory(bil.getCategory());
		bil.setTitle(bill.getTitle());
		bil.setAmount(bill.getAmount());
		bil.setDateOfEntry(bill.getDateOfEntry());
		bil.setDueDate(bill.getDueDate());
		bil.setPad(bill.getPad());
		bil.setUnpad(bill.getUnpad());
		repository.delete(bil);
           return bill;
	}

	@Override
	public Long updateBill(BillTrackerDetailsDTO bill) {
		BillTrackerDetails bil = new BillTrackerDetails();
		//bil.setId(bill.getId());
		bil.setCategory(bil.getCategory());
		bil.setTitle(bill.getTitle());
		bil.setAmount(bill.getAmount());
		bil.setDateOfEntry(bill.getDateOfEntry());
		bil.setDueDate(bill.getDueDate());
		bil.setPad(bill.getPad());
		bil.setUnpad(bill.getUnpad());
		repository.save(bil);
		return bill.getId();

	}
	@Override
	public BillTrackerDetailsDTO createBill(BillTrackerDetailsDTO bill) {
		BillTrackerDetails bil = new BillTrackerDetails();
		//bil.setId(bill.getId());
		bil.setCategory(bil.getCategory());
		bil.setTitle(bill.getTitle());
		bil.setAmount(bill.getAmount());
		bil.setDateOfEntry(bill.getDateOfEntry());
		bil.setDueDate(bill.getDueDate());
		bil.setPad(bill.getPad());
		bil.setUnpad(bill.getUnpad());
		repository.save(bil);
		return bill;

	
	}
}
