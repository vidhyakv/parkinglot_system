package com.parkinglot.command;


import com.parkinglot.model.MallFeeModel;
import com.parkinglot.service.ParkingLot;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class ConfigureFeeModelTest extends CommandTest {

	private ConfigureFeeModel configureFeeModel;

	@Before
	public void setUp() throws Exception {
		configureFeeModel = new ConfigureFeeModel();
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void shouldConfigureFeeModel() throws Exception {
		configureFeeModel.setParkingManager(parkingManager);
		when(parkingManager.getParkingLot()).thenReturn(new ParkingLot());

		configureFeeModel.execute(new String[] {"Mall"});
		assertThat(configureFeeModel.parkingManager.getParkingLot().getFeeModel(),instanceOf(MallFeeModel.class));

	}
}