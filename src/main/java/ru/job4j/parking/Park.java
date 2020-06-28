package ru.job4j.parking;

public interface Park {
    void add(Car car);
    boolean checkFreePlace(Car car);
}
