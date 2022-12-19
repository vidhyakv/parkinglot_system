package com.parkinglot.command;


import com.parkinglot.model.Slot;
import com.parkinglot.service.ParkingLot;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import java.util.concurrent.atomic.AtomicInteger;


public class AllotParkingLotCommandTest extends CommandTest {
    private AllotParkingLotCommand allotParkingLotCommand;

    @Before
    public void setUp() throws Exception {
        allotParkingLotCommand = new AllotParkingLotCommand();
    }

    @Test
    public void shouldAllotSlotsToParkingLot() throws Exception {
        allotParkingLotCommand.setParkingManager(parkingManager);
        when(parkingManager.getParkingLot()).thenReturn(new ParkingLot());
        allotParkingLotCommand.execute(new String[] { "Motorcycles/scooters:2", "Cars/SUVs/Buses/Trucks:NA" });
        assertEquals(parkingManager.getParkingLot().getSlots().size(), 2);
    }


    @Test
    public void shouldAllotSlotsToParkingLotForMotorcycle() throws Exception {
        allotParkingLotCommand.setParkingManager(parkingManager);
        when(parkingManager.getParkingLot()).thenReturn(new ParkingLot());
        allotParkingLotCommand.execute(new String[] { "Motorcycles/Scooters:2" });
        assertEquals(parkingManager.getParkingLot().getSlots().size(), 1);
        assertEquals(parkingManager.getParkingLot().getSlots("Motorcycles/Scooters").size(), 2);
        AtomicInteger indexHolder = new AtomicInteger();
        parkingManager.getParkingLot().getSlots("Motorcycles/Scooters").forEach(element->{
            assertThat(element, instanceOf(Slot.class));
            assertEquals(element.getSlotId(), indexHolder.getAndIncrement()+1);
        });
    }

    @Test
    public void shouldNotAllotSlotsToParkingLotForCars() throws Exception {
        allotParkingLotCommand.setParkingManager(parkingManager);
        when(parkingManager.getParkingLot()).thenReturn(new ParkingLot());
        allotParkingLotCommand.execute(new String[] { "Cars/SUVs/Buses/Trucks:NA" });
        assertEquals(parkingManager.getParkingLot().getSlots().size(), 1);
        assertEquals(parkingManager.getParkingLot().getSlots("Cars/SUVs/Buses/Trucks"), null);
    }
}
