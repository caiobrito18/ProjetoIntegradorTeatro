import javax.swing.JOptionPane;

import classes.Area;
import classes.Client;
import classes.Theater;
import java.util.HashMap;
import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;

public class Methods {
  public static void printArray(Area e) {
    for (int i = 0; i < e.getTotalSeats() - 2; i++) {
      if(e.isSeatOccupied(i))
      {  System.out.println("[ XX ]"); }
      else{ System.out.println("["+i+"]");}
      }
    }

        public void buyTicket(String cpf, String pieceName, String turn, int area, HashMap<Integer,Client> clients, Theater teatro, int seat) {
          
            if (cpf == null || cpf.isEmpty()) {
                System.out.println("");
                return;
            }

            if (pieceName == null) {
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

            if (!clientes.containsKey(cpf)) {
                clientes.put(cpf, new Cliente(cpf));
            }
            Cliente cliente = clientes.get(cpf);
            Peca peca = pecas.get(pecaNome);
            Sessao sessao = peca.getSessoes().get(sessaoNome);
            Area area = teatro.getAreas().get(areaNome);

            if (area.isPoltronaOcupada(poltrona - 1)) {
                JOptionPane.showMessageDialog(Main.this, "Poltrona já está ocupada!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Ingresso ingresso = new Ingresso(cpf, pecaNome, sessaoNome, areaNome, poltrona, area.getPreco());
                cliente.adicionarIngresso(ingresso);
                sessao.adicionarIngresso(ingresso);
                area.comprarPoltrona(poltrona - 1);
                JOptionPane.showMessageDialog(Main.this, "Ingresso comprado com sucesso!");
                atualizarPoltronas();
            }
        }
    }
  }