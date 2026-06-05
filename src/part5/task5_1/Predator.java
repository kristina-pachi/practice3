package part5.task5_1;

public abstract class Predator extends Animal {
    public Predator(String name, int age, double weight, int energyLevel) {
        super(name, age, weight, energyLevel);
    }

    public void hunt() {
        // Успешная охота: +30 энергии, -0.5 кг веса (стресс/расход)
        energyLevel = Math.min(100, energyLevel + 30);
        weight = Math.max(0.0, weight - 0.5);
        System.out.printf("%s охотится: энергия=%d%%, вес=%.2fkg%n", name, energyLevel, weight);
    }
}

