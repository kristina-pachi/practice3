package part5.task5_1;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, int age, double weight, int energyLevel) {
        super(name, age, weight, energyLevel);
    }

    public void graze() {
        // Пастбище: +15 энергии, небольшой прирост веса
        energyLevel = Math.min(100, energyLevel + 15);
        weight += 0.2;
        System.out.printf("%s пасётся: энергия=%d%%, вес=%.2fkg%n", name, energyLevel, weight);
    }
}

