package objects;

import java.util.ArrayList;
import java.util.List;

public class Turn {

  private final List<Ticket> tickets;

  public Turn() {
    this.tickets = new ArrayList<>();
  }

  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
  }

  public void removeTicket(Ticket ticket) {
    tickets.remove(ticket);
  }

  public int getTotalTicketsSold() {
    return tickets.size();
  }

  public double getRevenue() {
    return tickets.stream().mapToDouble(Ticket::getPreco).sum();
  }
}
