
package com.billTracker.FsePaBillTracker.boundary;

import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.boundaryTestFile;
import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.currentTest;
import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.yakshaAssert;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.billTracker.FsePaBillTracker.controller.BillController;
import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;
import com.billTracker.FsePaBillTracker.service.BillServiceImpl;
import com.billTracker.FsePaBillTracker.utilityclasses.MasterData;

@RunWith(SpringRunner.class)

@WebMvcTest(BillController.class)
class EntityValidationTest {

	@MockBean
	private BillServiceImpl billServiceImpl;

	private Validator validator;

	@BeforeEach
	void setUp() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void testTitle() throws Exception {
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setTitle("phone");
		Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(billTrackerDetailsDTO);
		yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

	}

	@Test
	void testAmount() throws Exception {
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setAmount(4564);
		Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(billTrackerDetailsDTO);
		yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

	}

	@Test
	void testCategory() throws Exception {
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setCategory("new");
		Set<ConstraintViolation<BillTrackerDetailsDTO>> violations = validator.validate(billTrackerDetailsDTO);
		yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);

	}

}
