package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Park {
    private int sizePass;
    private int sizeTruck;
    private List<Car> carPassenger = new ArrayList<>(sizePass);
    private List<Car> trucks = new ArrayList<>(sizeTruck);
    private int passPlaces;
    private int truckPlaces;

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
            if (car.getSizeCar() == 1) {
                carPassenger.add(car);
                passPlaces++;
            } else if (car.getSizeCar() > 1 && truckPlaces == sizeTruck) {
                carPassenger.add(car);
                passPlaces += car.getSizeCar();
            } else {
                trucks.add(car);
                truckPlaces++;
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
        if (passPlaces < sizePass && car.getSizeCar() == 1) {
            rsl = true;
        } else if (car.getSizeCar() > 1
                && sizeTruck - truckPlaces >= car.getSizeCar()
                || sizePass - passPlaces >= car.getSizeCar()) {
            rsl = true;
        }
        return rsl;
    }
}
