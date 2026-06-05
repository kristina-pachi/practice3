package part3.task3_1;

import java.util.ArrayList;
import java.util.List;

public class VehicleDemo {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();

        Car toyota = new Car("Toyota", "Camry", 2020, 0.5, 4, true);         // автомат, полбака
        Car lada = new Car("Lada", "Vesta", 2018, 0.3, 4, false);           // механика
        Truck kamaz = new Truck("Kamaz", "5490", 2015, 0.6, 10.0);         // грузоподъёмность 10 т
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2021,
                0.0, 4, true, 0.6, 500.0); // батарея 60%, max range 500 km

        fleet.add(toyota);
        fleet.add(lada);
        fleet.add(kamaz);
        fleet.add(tesla);

        double distance = 500.0;
        System.out.println("Информация по флоту (расход на " + (int)distance + " км):\n");

        for (Vehicle v : fleet) {
            System.out.println(v.toString());
            System.out.println("Тип: " + v.getType());

            double consumption = v.getFuelConsumption();
            if (consumption > 0.0) {
                double liters = v.calculateFuelNeeded(distance);
                System.out.printf("Расход на %.0f км: %.2f л (%.2f л/100км)%n", distance, liters, consumption);
            } else {
                System.out.printf("Расход на %.0f км: 0 л (электрический привод)%n", distance);
            }

            // Для электромобилей показать запас хода
            if (v instanceof Electric) {
                Electric e = (Electric) v;
                System.out.printf("Текущий запас хода: %.0f км (battery=%.0f%%)%n", e.getRangeKm(), e.getBatteryLevel() * 100.0);
            }

            // Car — гудок, если Electric,то показать range через интерфейс
            if (v instanceof Car) {
                ((Car) v).honk();
            }
            if (v instanceof Electric) {
                Electric e = (Electric) v;
                System.out.printf("Вызов getRangeKm() через интерфейс Electric: %.0f км%n", e.getRangeKm());
            }

            System.out.println();
        }

        // Пример использования canTravel
        double tankCapacity = 60.0;
        System.out.printf("%s может проехать %.0f км при баке %.0f л: %s%n",
                toyota.getBrand() + " " + toyota.getModel(),
                distance, tankCapacity,
                toyota.canTravel(distance, tankCapacity) ? "ДА" : "НЕТ");
    }
}

