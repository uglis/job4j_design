package ru.job4j.parking;

import java.util.Objects;

abstract public class Car {
    private String name;
    private int sizeCar;

    public Car(String name, int sizeCar) {
        this.name = name;
        this.sizeCar = sizeCar;
    }

    public int getSizeCar() {
        return sizeCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return sizeCar == car.sizeCar
                && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sizeCar);
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", sizeCar=" + sizeCar
                + '}';
    }
}
