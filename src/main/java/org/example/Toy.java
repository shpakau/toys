import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    // конструктор
    public Toy() {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // добавление новой игрушки
    public void addToy(int id, String name, int quantity, double weight) throws IOException {
        FileWriter writer = new FileWriter("toys.txt", true);
        writer.write(id + ";" + name + ";" + quantity + ";" + weight + "\n");
        writer.close();
    }

    // изменение веса игрушки
    public void changeWeight(int toyId, double newWeight) throws IOException {
        File file = new File("toys.txt");
        Scanner scanner = new Scanner(file);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");

            if (Integer.parseInt(parts[0]) == toyId) {
                lines.add(parts[0] + ";" + parts[1] + ";" + parts[2] + ";" + newWeight);
            } else {
                lines.add(line);
            }
        }
        scanner.close();

        FileWriter writer = new FileWriter(file);
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    // розыгрыш призовой игрушки
    public Toy play() throws IOException {
        File file = new File("toys.txt");
        Scanner scanner = new Scanner(file);

        List<Toy> toys = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            double weight = Double.parseDouble(parts[3]);
            Toy toy = new Toy();
            toy.setId(id);
            toy.setName(name);
            toy.setQuantity(quantity);
            toy.setWeight(weight);
            toys.add(toy);
        }
        scanner.close();

        List<Toy> prizes = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.getWeight() > 0) {
                prizes.add(toy);
            }
        }

        double totalWeight = 0.0;
        for (Toy toy : prizes) {
            totalWeight += toy.getWeight();
        }

        double randomWeight = new Random().nextDouble() * totalWeight;
        Toy selectedToy = null;
        for (Toy toy : prizes) {
            randomWeight -= toy.getWeight();
            if (randomWeight <= 0) {
                selectedToy = toy;
                break;
            }
        }

        if (selectedToy == null) {
            System.out.println("Игрушка не выбрана в качестве приза.");
        } else {
            System.out.println("Приз: " + selectedToy.getName());
        }

        return selectedToy;
    }
}