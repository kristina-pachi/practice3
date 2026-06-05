package part3.task3_1;

public class ElectricCar extends Car implements Electric {
    private double batteryLevel;
    private final double maxRangeKm;

    public ElectricCar(String brand, String model, int year,
                       double fuelLevel, int doors, boolean automatic,
                       double batteryLevel, double maxRangeKm) {
        super(brand, model, year, fuelLevel, doors, automatic);
        setBatteryLevel(batteryLevel);
        this.maxRangeKm = maxRangeKm;
    }

    private void setBatteryLevel(double level) {
        if (level < 0.0) level = 0.0;
        if (level > 1.0) level = 1.0;
        this.batteryLevel = level;
    }

    @Override
    public double getBatteryLevel() { return batteryLevel; }

    @Override
    public double getRangeKm() { return batteryLevel * maxRangeKm; }

    @Override
    public void charge(double hours) {
        if (hours <= 0) return;
        // Зарядка: 20% в час
        double increase = 0.2 * hours;
        setBatteryLevel(Math.min(1.0, batteryLevel + increase));
    }

    @Override
    public double getFuelConsumption() {
        // Электромобиль не потребляет бензин
        return 0.0;
    }

    @Override
    public String getType() {
        return "ElectricCar";
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) ElectricCar [battery=%.0f%%, range=%.0f km]",
                getBrand(), getModel(), getYear(), getBatteryLevel() * 100.0, getRangeKm());
    }
}

