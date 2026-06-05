package part3.task3_1;

public class Truck extends Vehicle {
    private final double cargoCapacityTons;

    public Truck(String brand, String model, int year, double fuelLevel, double cargoCapacityTons) {
        super(brand, model, year, fuelLevel);
        this.cargoCapacityTons = cargoCapacityTons;
    }

    public double getCargoCapacityTons() { return cargoCapacityTons; }

    @Override
    public double getFuelConsumption() {
        // Базовый расход 20 л/100км + 3 л/100км на тонну груза
        return 20.0 + cargoCapacityTons * 3.0;
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) Truck [cargo=%.1f t, fuel=%.0f%%]",
                getBrand(), getModel(), getYear(), cargoCapacityTons, getFuelLevel() * 100.0);
    }
}

