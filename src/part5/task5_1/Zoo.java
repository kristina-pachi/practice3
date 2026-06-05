package part5.task5_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Zoo {
    private final List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal a) {
        if (a != null) animals.add(a);
    }

    public void feedAll(int caloriesPerAnimal) {
        for (Animal a : animals) {
            a.eat(caloriesPerAnimal);
            System.out.printf("Накормили %s (%s): энергия=%d%%%n", a.getName(), a.getClass().getSimpleName(), a.getEnergyLevel());
        }
    }

    public void makeNoise() {
        for (Animal a : animals) {
            a.makeSound();
        }
    }

    public List<Animal> getHungryAnimals() {
        return animals.stream()
                .filter(a -> a.getEnergyLevel() < 30)
                .collect(Collectors.toList());
    }

    public Optional<Animal> findAnimal(String name) {
        return animals.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Animal> getAll() {
        return List.copyOf(animals);
    }
}

