package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Park {
    private int sizePass;
    private int sizeTruck;
    private List<Car> carPassenger = new ArrayList<>(sizePass);
    private List<Car> trucks = new ArrayList<>(sizeTruck);
    private int pointPass = 0;
    private int pointTruck = 0;

    public Parking(int sizePass, int sizeTruck) {
        this.sizePass = sizePass;
        this.sizeTruck = sizeTruck;
    }

    /**
     * Add car in parking.
     *
     * @param car car.
     */
    @Override
    public void add(Car car) {
        if (checkFreePlace(car)) {
            if (car.getTypeCar().equals(CarType.Truck) && pointTruck == sizeTruck) {
                carPassenger.add(car);
                pointPass += 2;
            } else if (car.getTypeCar().equals(CarType.PassengerCar)) {
                carPassenger.add(car);
                pointPass++;
            } else {
                trucks.add(car);
                pointTruck++;
            }
        }
    }

    /**
     * Checking free place for new car.
     *
     * @param car car.
     * @return have or not place.
     */
    @Override
    public boolean checkFreePlace(Car car) {
        boolean rsl = false;
        if (car.getTypeCar().equals(CarType.PassengerCar) && pointPass < carPassenger.size()) {
            rsl = true;
        } else if (car.getTypeCar().equals(CarType.Truck) && pointTruck < trucks.size()
                || pointPass < (sizePass - 1)) {
            rsl = true;
        }
        return rsl;
    }
}
