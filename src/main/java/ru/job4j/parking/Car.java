package ru.job4j.parking;

import java.util.Objects;

abstract public class Car {
    private String name;
    private String color;
    private CarType typeCar;


    public Car(String name, String color, CarType typeCar) {
        this.name = name;
        this.color = color;
        this.typeCar = typeCar;
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
        return Objects.equals(name, car.name)
                && Objects.equals(color, car.color)
                && typeCar == car.typeCar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, typeCar);
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + ", typeCar=" + typeCar
                + '}';
    }
}
