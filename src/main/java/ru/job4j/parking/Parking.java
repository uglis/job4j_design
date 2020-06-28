package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Park {
    private int size;
    private List<Car> cars = new ArrayList<>(size);
    private int point = 0;

    public Parking(int size) {
        this.size = size;
    }

    /**
     * Add car in parking.
     *
     * @param car car.
     */
    @Override
    public void add(Car car) {
        if (checkFreePlace(car)) {
            if (car.getTypeCar().equals(CarType.PassengerCar)) {
                point++;
            } else {
                point += 2;
            }
            cars.add(car);
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
        if (point < size) {
            if (car.getTypeCar().equals(CarType.Truck) && size - point >= 2) {
                rsl = true;
            } else if (car.getTypeCar().equals(CarType.PassengerCar) && size - point >= 1) {
                rsl = true;
            }
        }
        return rsl;
    }
}
