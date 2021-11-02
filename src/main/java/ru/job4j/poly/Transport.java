package ru.job4j.poly;

public interface Transport {
    void move();

    void passengers(int paxNumber);

    double refuel(int fuelNumber);
}
