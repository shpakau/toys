import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            Toy toy = new Toy();
            Toy selectedToy = toy.play();
            if (selectedToy != null) {
                System.out.println("Вы выиграли игрушку: " + selectedToy.getName());
            } else {
                System.out.println("К сожалению, никто не выиграл призовую игрушку.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}