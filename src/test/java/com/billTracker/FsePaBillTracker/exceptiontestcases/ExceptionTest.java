package com.billTracker.FsePaBillTracker.exceptiontestcases;

import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.currentTest;
import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.exceptionTestFile;
import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.yakshaAssert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.billTracker.FsePaBillTracker.controller.BillController;
import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;
import com.billTracker.FsePaBillTracker.service.BillServiceImpl;
import com.billTracker.FsePaBillTracker.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(BillController.class)
class ExceptionTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BillServiceImpl billServiceImpl;
	@Test
	void testupdateBillException() throws Exception  {
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setTitle("phone");
		billTrackerDetailsDTO.setCategory("new");
		when(billServiceImpl.updateBill(MasterData.getBillTrackerDetailsDTO()))
		.thenReturn(MasterData.getBillTrackerDetailsDTO().getId());
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addbill")
				.content(MasterData.asJsonString(MasterData.getBillTrackerDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"), 
		exceptionTestFile);

	}
	@Test
	void testDeleteBillException() throws Exception {
		
		BillTrackerDetailsDTO billTrackerDetailsDTO = MasterData.getBillTrackerDetailsDTO();
		billTrackerDetailsDTO.setTitle("phone");
		billTrackerDetailsDTO.setCategory("new");
		when(billServiceImpl.deleteBill(MasterData.getBillTrackerDetailsDTO()))
		.thenReturn(MasterData.getBillTrackerDetailsDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deletebill")
				.content(MasterData.asJsonString(MasterData.getBillTrackerDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), 
		exceptionTestFile);
		
		
	}

}
