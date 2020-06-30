package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {
    @Test
    public void whenHaveTruckAndFullParking() {
        Parking parking = new Parking(1, 2);
        parking.add(new Truck("truck1"));
        parking.add(new Truck("truck2"));
        parking.add(new Truck("car3"));
        Truck bmv = new Truck("bmb");
        boolean result = parking.checkFreePlace(bmv);
        assertThat(result, is(false));
    }

    @Test
    public void whenTruckSize2AndPassSize2AndHave2CarAlreadyParked() {
        Parking parking = new Parking(2, 2);
        parking.add(new Truck("truck2"));
        parking.add(new Truck("car3"));
        Truck truck = new Truck("truck3");
        PassengerCar bmv = new PassengerCar("bmb");
        boolean resultTruck = parking.checkFreePlace(truck);
        parking.add(truck);
        boolean resultPassCar = parking.checkFreePlace(bmv);
        assertThat(resultTruck, is(true));
        assertThat(resultPassCar, is(false));
    }

    @Test
    public void whenHaveTruckSize1AndPassSize3AndWantToAddTruck() {
        Parking parking = new Parking(3, 1);
        parking.add(new Truck("truck1"));
        parking.add(new PassengerCar("truck2"));
        Truck truck = new Truck("car");
        boolean rls = parking.checkFreePlace(truck);
        assertThat(rls, is(true));
    }
}