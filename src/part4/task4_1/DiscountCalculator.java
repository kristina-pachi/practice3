package part4.task4_1;

public class DiscountCalculator {

    // 1. По типу клиента (String)
    public static double calculateDiscount(double price, String customerType) {
        return switch (customerType.toLowerCase()) {
            case "vip" -> price * 0.30;
            case "regular" -> price * 0.10;
            case "new" -> price * 0.05;
            default -> 0;
        };
    }

    // 2. По количеству покупок (purchaseCount)
    public static double calculateDiscount(double price, int purchaseCount) {
        if (purchaseCount >= 100) return price * 0.20;
        if (purchaseCount >= 50) return price * 0.15;
        if (purchaseCount >= 10) return price * 0.10;
        return 0;
    }

    // 3. По промокоду + флаг первого заказа
    public static double calculateDiscount(double price, String promoCode, boolean isFirstOrder) {
        double discount = 0;
        if ("SAVE10".equals(promoCode)) discount = price * 0.10;
        if ("SAVE20".equals(promoCode)) discount = price * 0.20;
        if (isFirstOrder) discount += price * 0.05; // дополнительная скидка новым
        return Math.min(discount, price * 0.50); // не более 50%
    }

    // 4. Новая перегрузка: по возрасту клиента и сезону (age, season)
    //    - младше 18: 5%
    //    - 65 и старше: 15%
    //    - сезон: "winter" +10%, "summer" +5%
    //    Суммарная скидка не превышает 50%
    public static double calculateDiscount(double price, int age, String season) {
        double discount = 0.0;

        if (age < 18) discount += price * 0.05;
        if (age >= 65) discount += price * 0.15;

        if (season != null) {
            switch (season.toLowerCase()) {
                case "winter" -> discount += price * 0.10;
                case "summer" -> discount += price * 0.05;
                default -> { /* другие сезоны не дают дополнительной скидки */ }
            }
        }

        return Math.min(discount, price * 0.50);
    }

    public static void main(String[] args) {
        double price = 10000.0;

        System.out.printf("Скидка VIP-клиента: %.2f руб.%n", calculateDiscount(price, "vip"));
        System.out.printf("Скидка за 75 покупок: %.2f руб.%n", calculateDiscount(price, 75));
        System.out.printf("Скидка SAVE20 + первый заказ: %.2f руб.%n",
                calculateDiscount(price, "SAVE20", true));

        // Тест новой перегрузки по возрасту и сезону
        System.out.printf("Скидка для 70-летнего зимой: %.2f руб.%n", calculateDiscount(price, 70, "winter"));
        System.out.printf("Скидка для 16-летнего летом: %.2f руб.%n", calculateDiscount(price, 16, "summer"));
        System.out.printf("Скидка для 30-летнего весной: %.2f руб.%n", calculateDiscount(price, 30, "spring"));
    }
}
