import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Input input = readFile("a_example");
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
}
