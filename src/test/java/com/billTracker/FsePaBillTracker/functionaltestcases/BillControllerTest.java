package com.billTracker.FsePaBillTracker.functionaltestcases;

import static org.mockito.Mockito.*;
import static com.billTracker.FsePaBillTracker.utilityclasses.TestUtils.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
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
import com.billTracker.FsePaBillTracker.service.BillServiceImpl;

import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;

import com.billTracker.FsePaBillTracker.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(BillController.class)
public class BillControllerTest {

	

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BillServiceImpl billServiceImpl;

	@Test
	public void testcreateBill() throws Exception {
		when(billServiceImpl.updateBill(MasterData.getBillTrackerDetailsDTO()))
		.thenReturn(MasterData.getBillTrackerDetailsDTO().getId());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addbill")
				.content(MasterData.asJsonString(MasterData.getBillTrackerDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
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
	public  void testdeleteBill() throws Exception{
		
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