package ru.job4j.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {
    @Ignore
    @Test
    public void whenHaveTruckAndFullParking() {
        Parking parking = new Parking(5);
        parking.add(new Truck("truck1", "black", CarType.Truck));
        parking.add(new Truck("truck2", "white", CarType.Truck));
        parking.add(new Truck("car3", "white", CarType.PassengerCar));
        PassengerCar bmv = new PassengerCar("bmb", "yellow", CarType.PassengerCar);
        boolean result = parking.checkFreePlace(bmv);
        assertThat(result, is(false));
    }

    @Ignore
    @Test
    public void whenParkingSize4AndHave2CarAlreadyParked() {
        Parking parking = new Parking(4);
        parking.add(new Truck("truck2", "white", CarType.Truck));
        parking.add(new Truck("car3", "white", CarType.PassengerCar));
        Truck truck = new Truck("truck3", "black", CarType.Truck);
        PassengerCar bmv = new PassengerCar("bmb", "yellow", CarType.PassengerCar);
        boolean resultTruck = parking.checkFreePlace(truck);
        boolean resultPassCar = parking.checkFreePlace(bmv);
        assertThat(resultTruck, is(false));
        assertThat(resultPassCar, is(true));
    }
}