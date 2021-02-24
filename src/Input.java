import java.util.List;

public class Input {
    public List<Pizza> pizzas;
    public int[] teams = new int[5];

    public Input(List<Pizza> pizzas, int[] teams) {
        this.pizzas = pizzas;
        this.teams[2] = teams[0];
        this.teams[3] = teams[1];
        this.teams[4] = teams[2];
    }
}
