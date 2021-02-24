import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Input input = readFile("a_example");

        List<Delivery> deliveries = new ArrayList<>();
        List<Integer> pizzas1 = new ArrayList<>();
        pizzas1.add(1);
        pizzas1.add(4);
        List<Integer> pizzas2 = new ArrayList<>();
        pizzas2.add(0);
        pizzas2.add(2);
        pizzas2.add(3);
        deliveries.add(new Delivery(pizzas1));
        deliveries.add(new Delivery(pizzas2));
        Output output = new Output(deliveries);
        writeFile(output);
    }

    public static Input readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input/" + fileName + ".in"))) {
            String[] firstLine = reader.readLine().split(" ");
            int nrPizzas = Integer.parseInt(firstLine[0]);
            int[] teams = new int[3];
            teams[0] = Integer.parseInt(firstLine[1]);
            teams[1] = Integer.parseInt(firstLine[2]);
            teams[2] = Integer.parseInt(firstLine[3]);
            List<Pizza> pizzas = new ArrayList<>();
            for (int i = 0; i < nrPizzas; i++) {
                String[] line = reader.readLine().split(" ");
                List<String> ingredients = new ArrayList<>();
                for (int j = 0; j < Integer.parseInt(line[0]); j++) {
                    ingredients.add(line[j + 1]);
                }
                pizzas.add(new Pizza(ingredients));
            }
            return new Input(pizzas, teams);
        }
    }

    public static void writeFile(Output output) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.out"))) {
            writer.println(output.deliveries.size());
            for (Delivery delivery : output.deliveries) {
                writer.print(delivery.pizzas.size());
                for (Integer pizza : delivery.pizzas) {
                    writer.print(" " + pizza);
                }
                writer.print("\n");
            }
        }
    }
}
