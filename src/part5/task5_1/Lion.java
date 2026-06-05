package part5.task5_1;

import java.util.ArrayList;
import java.util.List;

public class Lion extends Predator implements Trainable {
    private final List<String> commands = new ArrayList<>();

    public Lion(String name, int age, double weight, int energyLevel) {
        super(name, age, weight, energyLevel);
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Р-р-р!");
    }

    public void roar() {
        System.out.println(name + " ревёт: РРРАААА!");
        // рев — затратная активность
        energyLevel = Math.max(0, energyLevel - 10);
    }

    @Override
    public void train(String command) {
        if (command == null || command.isBlank()) return;
        commands.add(command);
        // тренировка тратит энергию, но добавляет послушание
        energyLevel = Math.max(0, energyLevel - 5);
        System.out.printf("%s обучен команде: '%s' (энергия=%d%%)%n", name, command, energyLevel);
    }

    @Override
    public List<String> listCommands() {
        return List.copyOf(commands);
    }
}

