package com.billTracker.FsePaBillTracker.utilityclasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.billTracker.FsePaBillTracker.dtos.BillTrackerDetailsDTO;

public class MasterData {

	public static BillTrackerDetailsDTO getBillTrackerDetailsDTO() {

		BillTrackerDetailsDTO details = new BillTrackerDetailsDTO();
		details.setId(1l);
		details.setTitle("phone");
		details.setCategory("nokika");
		details.setAmount(4564);
		details.setDateOfEntry("2020-10-03");
		details.setDueDate("2020-10-03");
		details.setPad("no");
		details.setUnpad("yes");
		return details;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
