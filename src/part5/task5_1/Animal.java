package part5.task5_1;

public abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;
    protected int energyLevel; // 0 .. 100

    public Animal(String name, int age, double weight, int energyLevel) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name required");
        this.name = name;
        this.age = Math.max(0, age);
        this.weight = Math.max(0.0, weight);
        this.energyLevel = Math.max(0, Math.min(100, energyLevel));
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
    public int getEnergyLevel() { return energyLevel; }

    public void eat(int calories) {
        if (calories <= 0) return;
        // Простая модель: каждые 100 калорий дают +1 энергии (до 100)
        int energyGain = calories / 100;
        energyLevel = Math.min(100, energyLevel + energyGain);
        // и прибавляют вес: 1000 калорий -> +0.1 кг
        weight += (calories / 1000.0) * 0.1;
    }

    public void sleep(int hours) {
        if (hours <= 0) return;
        // Каждый час сна даёт +10 энергии
        energyLevel = Math.min(100, energyLevel + hours * 10);
    }

    public abstract void makeSound();

    @Override
    public String toString() {
        return String.format("%s{name='%s', age=%d, weight=%.2fkg, energy=%d%%}",
                getClass().getSimpleName(), name, age, weight, energyLevel);
    }
}

