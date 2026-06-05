package part3.task3_1;

public class Car extends Vehicle {
    private final int doors;
    private final boolean automatic;

    public Car(String brand, String model, int year, double fuelLevel, int doors, boolean automatic) {
        super(brand, model, year, fuelLevel);
        this.doors = doors;
        this.automatic = automatic;
    }

    public int getDoors() { return doors; }
    public boolean isAutomatic() { return automatic; }

    @Override
    public double getFuelConsumption() {
        // Примерные значения: автомат — 9.5 л/100км, механика — 8.0 л/100км
        return automatic ? 9.5 : 8.0;
    }

    @Override
    public String getType() {
        return "Car";
    }

    public void honk() {
        System.out.printf("%s %s: Гудок!%n", getBrand(), getModel());
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) Car [doors=%d, automatic=%s, fuel=%.0f%%]",
                getBrand(), getModel(), getYear(), doors, automatic ? "yes" : "no", getFuelLevel() * 100.0);
    }
}

