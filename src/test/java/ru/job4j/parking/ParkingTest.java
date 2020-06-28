package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {
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

    @Test
    public void whenHaveSize6And3TruckAndWantToAdd1Car() {
        Parking parking = new Parking(6);
        parking.add(new Truck("truck1", "black", CarType.Truck));
        parking.add(new Truck("truck2", "white", CarType.Truck));
        parking.add(new Truck("truck3", "yellow", CarType.Truck));
        PassengerCar family = new PassengerCar("car", "black", CarType.PassengerCar);
        boolean rls = parking.checkFreePlace(family);
        assertThat(rls, is(false));
    }
}