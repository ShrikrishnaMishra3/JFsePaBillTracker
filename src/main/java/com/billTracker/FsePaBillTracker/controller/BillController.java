package com.billTracker.FsePaBillTracker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;
import com.billTracker.FsePaBillTracker.entitys.BillTrackerDetails;
import com.billTracker.FsePaBillTracker.service.BillService;





@RestController
public class BillController {

	@Autowired
	private BillService Service;

	@RequestMapping("/test")
	public String Test() {
		return "Hello Word";
	}
	
	@GetMapping("/allbilles")
	public List<BillTrackerDetailsDTO> getAllBilles() {
		return Service.getAllBilles();
	}
	
	@PostMapping("/addbill")
	public ResponseEntity<BillTrackerDetailsDTO> createBill(@RequestBody BillTrackerDetailsDTO bill) {
		HttpStatus status = HttpStatus.CREATED;
		BillTrackerDetailsDTO saved = Service.addBill(bill);
		return new ResponseEntity<>(saved, status);
	}

	@DeleteMapping("/deletebill")
	public void deleteBill(@RequestBody BillTrackerDetailsDTO bill) {
		Service.deleteBill(bill);

	}
}
