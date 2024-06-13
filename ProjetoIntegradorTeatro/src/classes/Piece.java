package classes;

import java.util.HashMap;
import java.util.Map;

public class Piece {
  private final String nome;
        private final Map<String, Turn> turns;

        public Piece(String nome) {
            this.nome = nome;
            this.turns = new HashMap<>();
            turns.put("Manhã", new Turn());
            turns.put("Tarde", new Turn());
            turns.put("Noite", new Turn());
        }

        public String getName() {
            return nome;
        }

        public Map<String, Turn> getTurns() {
            return turns;
        }

        public int getTotalIngressosSold() {
            return turns.values().stream().mapToInt(Turn::getTotalTicketsSold).sum();
        }

        public double getTotalRevenue() {
            return turns.values().stream().mapToDouble(Turn::getRevenue).sum();
        }
}
