package com.parkinglot.command;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class CreateParkingLotCommandTest {

	private CreateParkingLotCommand createParkingLotCommand;

	@Before
	public void setUp() throws Exception {
		createParkingLotCommand = new CreateParkingLotCommand();
	}

	@Test
	public void shouldCreateParkingLotAndAssignItToParkingManager() throws Exception {
		createParkingLotCommand.execute(new String[] {});
		assertNotNull(createParkingLotCommand.parkingManager.getParkingLot());
	}
}