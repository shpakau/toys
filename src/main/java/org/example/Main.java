import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Toy toy = new Toy();

        System.out.println("1 - Добавьте новую игрушку");
        System.out.println("2 - Изменение веса игрушки");
        System.out.println("3 - Попробуешь выиграть?");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Введите ID игрушки:");
                int id = scanner.nextInt();
                System.out.println("Напишите название игрушки:");
                String name = scanner.next();
                System.out.println("Введите количество игрушек:");
                int quantity = scanner.nextInt();
                System.out.println("Введите вес игрушки:");
                double weight = scanner.nextDouble();
                toy.addToy(id, name, quantity, weight);
                break;

            case 2:
                System.out.println("Введите ID игрушки:");
                int toyId = scanner.nextInt();
                System.out.println("Введите новый вес игрушки:");
                double newWeight = scanner.nextDouble();
                toy.changeWeight(toyId, newWeight);
                break;

            case 3:
                Toy prize = toy.play();
                System.out.println("Поздравляю! Вы выиграли " + prize.getName() + "!");
                break;

            default:
                System.out.println("Неправильно.");
                break;
        }
    }
}
