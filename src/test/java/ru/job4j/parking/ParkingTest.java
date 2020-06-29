package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {
    @Test
    public void whenHaveTruckAndFullParking() {
        Parking parking = new Parking(1, 2);
        parking.add(new Truck("truck1", "black", CarType.Truck));
        parking.add(new Truck("truck2", "white", CarType.Truck));
        parking.add(new Truck("car3", "white", CarType.PassengerCar));
        Truck bmv = new Truck("bmb", "yellow", CarType.Truck);
        boolean result = parking.checkFreePlace(bmv);
        assertThat(result, is(false));
    }

    @Test
    public void whenTruckSize2AndPassSize2AndHave2CarAlreadyParked() {
        Parking parking = new Parking(2, 2);
        parking.add(new Truck("truck2", "white", CarType.Truck));
        parking.add(new Truck("car3", "white", CarType.Truck));
        Truck truck = new Truck("truck3", "black", CarType.Truck);
        PassengerCar bmv = new PassengerCar("bmb", "yellow", CarType.PassengerCar);
        boolean resultTruck = parking.checkFreePlace(truck);
        boolean resultPassCar = parking.checkFreePlace(bmv);
        assertThat(resultTruck, is(true));
        assertThat(resultPassCar, is(true));
    }

    @Test
    public void whenHaveTruckSize1AndPassSize3AndWantToAddTruck() {
        Parking parking = new Parking(3, 1);
        parking.add(new Truck("truck1", "black", CarType.Truck));
        parking.add(new PassengerCar("truck2", "white", CarType.PassengerCar));
        Truck truck = new Truck("car", "black", CarType.Truck);
        boolean rls = parking.checkFreePlace(truck);
        assertThat(rls, is(true));
    }
}