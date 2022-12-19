package com.parkinglot.command;

import com.parkinglot.service.ParkingManager;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CommandTest {

	ParkingManager parkingManager = Mockito.mock(ParkingManager.class);

	protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}
