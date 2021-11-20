package ru.job4j.stream;

public class Aircraft {
    private String companyManufacturer;

    private String modelName;

    private int passengerCapacity;

    private boolean longHaul;

    private int fuelCapacity;

    private double cost;

    @Override
    public String toString() {
        return "Aircraft{"
                + "companyManufacturer='" + companyManufacturer + '\''
                + ", modelName='" + modelName + '\''
                + ", passengerCapacity=" + passengerCapacity
                + ", longHaul=" + longHaul
                + ", fuelCapacity=" + fuelCapacity
                + ", cost=" + cost
                + '}';
    }

    static class Builder {
        private String companyManufacturer;
        private String modelName;
        private int passengerCapacity;
        private boolean longHaul;
        private int fuelCapacity;
        private double cost;

        Builder buildCompanyManufacturer(String companyManufacturer) {
            this.companyManufacturer = companyManufacturer;
            return this;
        }

        Builder buildModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        Builder buildPassengerCapacity(int passengerCapacity) {
            this.passengerCapacity = passengerCapacity;
            return this;
        }

        Builder buildLongHaul(boolean longHaul) {
            this.longHaul = longHaul;
            return this;
        }

        Builder buildFuelCapacity(int fuelCapacity) {
            this.fuelCapacity = fuelCapacity;
            return this;
        }

        Builder buildCost(double cost) {
            this.cost = cost;
            return this;
        }

        Aircraft build() {
            Aircraft aircraft = new Aircraft();
            aircraft.companyManufacturer = companyManufacturer;
            aircraft.longHaul = longHaul;
            aircraft.cost = cost;
            aircraft.modelName = modelName;
            aircraft.passengerCapacity = passengerCapacity;
            aircraft.fuelCapacity = fuelCapacity;
            return aircraft;
        }
    }

    public static void main(String[] args) {
        Aircraft a320 = new Builder()
                .buildCompanyManufacturer("AirBus")
                .buildModelName("A320")
                .buildLongHaul(false)
                .buildFuelCapacity(63500)
                .buildPassengerCapacity(180)
                .buildCost(75000.0D)
                .build();
        System.out.println(a320);
    }
}
