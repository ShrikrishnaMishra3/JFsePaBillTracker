package com.billTracker.FsePaBillTracker.boundary;

import static org.mockito.Mockito.*;
import static  com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.junit4.SpringRunner;

import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;

import com.billTracker.FsePaBillTracker.utilityclasses.MasterData;


@RunWith(SpringRunner.class)
public class EntityValidationTest {
	
	

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testGiftOrdersSuccess() throws Exception {
		
		BillTrackerDetailsDTO details = MasterData.getBillTrackerDetailsDTO();
			Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(details);
			yakshaAssert(currentTest(), 
						 violations.isEmpty()? true : false, 
						 boundaryTestFile);
	}
	
	@Test
	public void testBuyerNameLength() throws Exception {

		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setPad("yes");
		Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(billTrackerDetailsDTO);
		yakshaAssert(currentTest(), 
					 violations.isEmpty()? true : false, 
					 boundaryTestFile);

	}
	
	@Test
	public void testCategory() throws Exception {
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setCategory("new");
		Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(billTrackerDetailsDTO);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);

	}

	

	@Test
	public void testTitle() throws Exception {
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setTitle("phone");
		Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(billTrackerDetailsDTO);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);
	}
	@Test
	public void testAmount() throws Exception {
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setAmount(100);
		Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(billTrackerDetailsDTO);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);
	}
}