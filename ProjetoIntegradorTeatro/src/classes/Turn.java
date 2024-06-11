package classes;

import java.util.ArrayList;
import java.util.List;

public class Turn {

  private final List<Ticket> tickets;

  public Turn() {
    this.tickets = new ArrayList<>();
  }

  public void adicionarTicket(Ticket ticket) {
    tickets.add(ticket);
  }

  public void removerTicket(Ticket ticket) {
    tickets.remove(ticket);
  }

  public int getTotalTicketsVendidos() {
    return tickets.size();
  }

  public double getReceita() {
    return tickets.stream().mapToDouble(Ticket::getPreco).sum();
  }
}
