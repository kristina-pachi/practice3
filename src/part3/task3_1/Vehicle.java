package part3.task3_1;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private double fuelLevel; // 0.0 .. 1.0

    protected Vehicle(String brand, String model, int year, double fuelLevel) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        setFuelLevel(fuelLevel);
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getFuelLevel() { return fuelLevel; }

    public void setFuelLevel(double fuelLevel) {
        if (fuelLevel < 0.0 || fuelLevel > 1.0) {
            throw new IllegalArgumentException("fuelLevel must be between 0.0 and 1.0");
        }
        this.fuelLevel = fuelLevel;
    }


    public abstract double getFuelConsumption();


    public abstract String getType();


    public double calculateFuelNeeded(double distanceKm) {
        double consumptionPer100 = getFuelConsumption();
        return distanceKm * consumptionPer100 / 100.0;
    }

    public boolean canTravel(double distanceKm, double tankCapacityLiters) {
        double needed = calculateFuelNeeded(distanceKm);
        double available = fuelLevel * tankCapacityLiters;
        return available >= needed;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) [fuel=%.0f%%]", brand, model, year, getFuelLevel() * 100.0);
    }
}

