import java.util.HashMap;
import java.util.List;

import objects.Area;
import objects.Client;
import objects.Piece;
import objects.Theater;
import objects.Ticket;
import objects.Turn;

public class Methods {
  public static void printArray(Area e) {
    for (int i = 0; i < e.getTotalSeats(); i++) {
      if (i % 10 == 0) {
        System.out.println("\n");
      }
      if (e.isSeatOccupied(i)) {
        System.out.print("[ XX ]");
      } else {
        System.out.print("[" + (i + 1) + "]");
      }
    }
    System.out.println("\n");
  }

  public static String buyTicket(String cpf, String piece, HashMap<String, Piece> pieces, String turn, Integer area,
      HashMap<String, Client> clients, Theater theater, Integer seat) {
    if (cpf == null || cpf.isEmpty()) {
      System.out.println("");
      return "Erro cpf vazio";
    }

    if (piece == null) {
      return "erro campo peça vazio";
    }

    if (turn == null) {
      return "erro campo turno vazio";
    }

    try {
      if (seat < 1 || seat > theater.getAreas().get(area).getTotalSeats()) {
        throw new NumberFormatException();
      }
    } catch (NumberFormatException ex) {
      return "número da cadeira inválido";
    }

    if (!clients.containsKey(cpf)) {
      clients.put(cpf, new Client(cpf));
    }
    Client currentClient = clients.get(cpf);
    Piece selectedPiece = pieces.get(piece);
    Turn selectedTurn = selectedPiece.getTurns().get(turn);
    Area selectedArea = theater.getAreas().get(area);

    if (selectedArea.isSeatOccupied(seat - 1)) {
      System.out.println("poltrona já se encontra ocupada");
      return "erro, a poltrona se encontra ocupada, tente novamente com outro número de poltrona";
    } else {
      Ticket ticket = new Ticket(cpf.toString(), piece.toString(), turn, area.toString(), seat,
          selectedArea.getPreco());
      currentClient.addTicket(ticket);
      selectedTurn.addTicket(ticket);
      selectedArea.buySeats(seat - 1);
      return "Ingresso comprado com sucesso";
    }
  }

  public static String printTicket(String cpf, HashMap<String, Client> clients) {
    if (!clients.containsKey(cpf)) {
      return "Erro, cliente não encontrado";
    }

    Client client = clients.get(cpf);
    List<Ticket> tickets = client.getTickets();

    if (tickets.isEmpty()) {
      return "Nenhum ticket atribuido a esse cpf";
    }

    StringBuilder recibo = new StringBuilder("Recibo de tickets:\n\n");
    tickets.forEach(Ticket -> recibo
        .append("poltrona:" + Ticket.getPoltrona() + "\n")
        .append("area:" + Ticket.getArea() + "\n")
        .append("peça:" + Ticket.getPeca() + "\n")
        .append("Sessão:" + Ticket.getSessao() + "\n")
        .append("\n"));
    recibo.append("\nTotal: R$ ").append(String.format("%.2f", tickets.stream().mapToDouble(Ticket::getPreco).sum()));

    return recibo.toString();
  }

  public static String statistics(HashMap<String, Piece> pieces, Theater teatro) {
    StringBuilder stats = new StringBuilder("Estatísticas de Vendas:\n\n");
    stats.append("Total de Ingressos Vendidos: ").append(teatro.getTotalTicketsSold()).append("\n");
    stats.append("Receita Total: R$ ").append(String.format("%.2f", teatro.getTotalRevenue())).append("\n\n");

    pieces.values().forEach(peca -> {
      stats.append("Peça: ").append(peca.getName()).append("\n");
      stats.append("Ingressos Vendidos: ").append(peca.getTotalTicketsSold()).append("\n");
      stats.append("Receita: R$ ").append(String.format("%.2f", peca.getTotalRevenue())).append("\n\n");
    });
    return stats.toString();
  }
}