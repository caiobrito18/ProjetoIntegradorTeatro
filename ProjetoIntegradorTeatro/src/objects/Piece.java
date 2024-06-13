package objects;

import java.util.HashMap;
import java.util.Map;

public class Piece {
    private final String nome;
    private final Map<String, Turn> turns;

    public Piece(String nome) {
        this.nome = nome;
        this.turns = new HashMap<>();
        turns.put("1", new Turn());
        turns.put("2", new Turn());
        turns.put("3", new Turn());
    }

    public String getName() {
        return nome;
    }

    public Map<String, Turn> getTurns() {
        return turns;
    }

    public int getTotalTicketsSold() {
        return turns.values().stream().mapToInt(Turn::getTotalTicketsSold).sum();
    }

    public double getTotalRevenue() {
        return turns.values().stream().mapToDouble(Turn::getRevenue).sum();
    }
}
