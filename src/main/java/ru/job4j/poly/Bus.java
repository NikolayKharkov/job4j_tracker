package ru.job4j.poly;

public class Bus implements Transport {
    private int paxNumber;

    @Override
    public void move() {
        System.out.println("Поехаллии !!!");
    }

    @Override
    public void passengers(int paxNumber) {
        this.paxNumber = paxNumber;
    }

    @Override
    public double refuel(int fuelNumber) {
        return fuelNumber * 1.75;
    }
}
