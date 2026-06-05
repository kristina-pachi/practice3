package part5.task5_1;

public class Elephant extends Herbivore {
    public Elephant(String name, int age, double weight, int energyLevel) {
        super(name, age, weight, energyLevel);
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Тууут!");
    }

    public void trumpet() {
        System.out.println(name + " трубит: ТРУУУУУТ!");
        energyLevel = Math.max(0, energyLevel - 5);
    }
}

