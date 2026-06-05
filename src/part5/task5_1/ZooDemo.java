package part5.task5_1;

import java.util.List;
import java.util.Optional;

public class ZooDemo {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Lion simba = new Lion("Simba", 5, 190.0, 40);
        Elephant dumbo = new Elephant("Dumbo", 10, 5400.0, 25);
        Lion nala = new Lion("Nala", 4, 160.0, 20);
        Elephant ella = new Elephant("Ella", 7, 4800.0, 80);

        zoo.addAnimal(simba);
        zoo.addAnimal(dumbo);
        zoo.addAnimal(nala);
        zoo.addAnimal(ella);

        System.out.println("=== Начальное состояние зоопарка ===");
        zoo.getAll().forEach(System.out::println);

        System.out.println("\n=== Демонстрация поведения ===");
        // Охота и пастбище
        simba.hunt();
        nala.hunt();
        dumbo.graze();
        ella.graze();

        System.out.println("\n=== Тренировка льва (Trainable) ===");
        simba.train("сидеть");
        simba.train("ко мне");
        System.out.println("Команды Simba: " + simba.listCommands());

        System.out.println("\n=== Кормим всех (500 калл каждому) ===");
        zoo.feedAll(500);

        System.out.println("\n=== Все животные издают звуки ===");
        zoo.makeNoise();

        System.out.println("\n=== Список голодных животных (энергия < 30) ===");
        List<Animal> hungry = zoo.getHungryAnimals();
        if (hungry.isEmpty()) {
            System.out.println("Голодных животных нет.");
        } else {
            hungry.forEach(a -> System.out.println("Голодный: " + a));
        }

        System.out.println("\n=== Поиск животного по имени ===");
        Optional<Animal> found = zoo.findAnimal("Dumbo");
        found.ifPresentOrElse(
                a -> System.out.println("Найдено: " + a),
                () -> System.out.println("Не найдено")
        );

        System.out.println("\n=== Финальное состояние зоопарка ===");
        zoo.getAll().forEach(System.out::println);
    }
}
