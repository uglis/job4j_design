package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Park {
    private int size;
    private List<Car> cars = new ArrayList<>(size);

    public Parking(int size) {
        this.size = size;
    }

    @Override
    public void add(Car car) {

    }

    @Override
    public boolean checkFreePlace(Car car) {
        return false;
    }
}
