package com.billTracker.FsePaBillTracker.functionaltestcases;

import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.businessTestFile;
import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.currentTest;
import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.yakshaAssert;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
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

import com.billTracker.FsePaBillTracker.service.BillServiceImpl;
import com.billTracker.FsePaBillTracker.utilityclasses.MasterData;
import com.billTracker.FsePaBillTracker.controller.BillController;
import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;

import com.billTracker.FsePaBillTracker.utilityclasses.MasterData;


@RunWith(SpringRunner.class)
@WebMvcTest(BillController.class)
public class TestBillContrller {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BillServiceImpl billServiceImpl;
	@Test
	public void testaddBill()throws Exception { 
		
		  when(billServiceImpl.updateBill(MasterData.getBillTrackerDetailsDTO()))
		  .thenReturn(MasterData.getBillTrackerDetailsDTO().getId());
		  
		  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addbill")
		  .content(MasterData.asJsonString(MasterData.getBillTrackerDetailsDTO()))
		  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
		  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  
		  
		  yakshaAssert(currentTest(), (result.getResponse().getStatus() ==
		  HttpStatus.OK.value() ? "true" : "false"), businessTestFile);
		 
	}
	@Test
	public void testallbilles() throws Exception {
		
		List<BillTrackerDetailsDTO>list = new ArrayList<BillTrackerDetailsDTO>();
		list.add(MasterData.getBillTrackerDetailsDTO());
		when(billServiceImpl.getAllBilles())
		.thenReturn(list);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/allbilles")
				.content(MasterData.asJsonString(MasterData.getBillTrackerDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	@Test
	public void deleteBill() throws Exception {
		
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
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	
		
	}
		
	}