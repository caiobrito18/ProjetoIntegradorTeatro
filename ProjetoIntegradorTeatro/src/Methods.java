import java.util.HashMap;

import classes.Area;
import classes.Client;
import classes.Piece;
import classes.Theater;
import classes.Ticket;
import classes.Turn;

public class Methods {
  public static void printArray(Area e) {
    for (int i = 0; i < e.getTotalSeats() - 2; i++) {
      if (e.isSeatOccupied(i)) {
        System.out.println("[ XX ]");
      } else {
        System.out.println("[" + i + "]");
      }
    }
  }

  public void buyTicket(String cpf, String piece, HashMap<String, Piece> pieces, String turn, Integer area,
      HashMap<String, Client> clients, Theater teatro, Integer seat) {

    if (cpf == null || cpf.isEmpty()) {
      System.out.println("");
      return;
    }

    if (piece == null) {
      return;
    }

    if (turn == null) {
      return;
    }

    try {
      if (seat < 1 || seat > teatro.getAreas().get(area).getTotalSeats()) {
        throw new NumberFormatException();
      }
    } catch (NumberFormatException ex) {
      return;
    }

    if (!clients.containsKey(cpf)) {
      clients.put(cpf, new Client(cpf));
    }
    Client currentClient = clients.get(cpf);
    Piece selectedPiece = pieces.get(piece);
    Turn selectedTurn = selectedPiece.getTurns().get(turn);
    Area selectedArea = teatro.getAreas().get(area);

    if (selectedArea.isSeatOccupied(seat - 1)) {
      System.out.println("poltrona já se encontra ocupada");
    } else {
      Ticket ticket = new Ticket(cpf.toString(), area.toString(), turn, area.toString(), seat,
          selectedArea.getPreco());
      currentClient.addTicket(ticket);
      selectedTurn.addTicket(ticket);
      selectedArea.buySeats(seat - 1);
      System.out.println("Ingresso comprado com sucesso");
    }
  }
}