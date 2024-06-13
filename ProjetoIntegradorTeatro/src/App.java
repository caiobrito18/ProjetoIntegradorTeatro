import java.util.HashMap;
import java.util.Scanner;

import classes.Client;
import classes.Piece;
import classes.Theater;

public class App {

  public void main(String[] args) {
    Theater theater = new Theater();
    HashMap<String, Client> clients = new HashMap<>();
    HashMap<String, Piece> pieces = new HashMap<>();
    String cpf;
    String piece;
    String turn;
    Integer area;
    Integer seat;
    Boolean rodando = true;

    pieces.put("1", new Piece("Peça 1"));
    pieces.put("2", new Piece("Peça 2"));
    pieces.put("3", new Piece("Peça 3"));
    Scanner input = new Scanner(System.in);
    while (rodando) {
      Integer opt;
      System.out.println("""
          Olá Seja Bem vindo ao sistema de compras de Ingressos do Teatro CELK
          O que Gostaria de Fazer?
          [1]Comprar um ingresso
          [2]imprimir ingresso
          [3]ver estátisticas de vendas
          [3]Sair
          """);
      opt = input.nextInt();
      switch (opt) {
        case 1:
          System.out.println("insira o cpf do titular do ingresso");
          System.out.println("Qual será a peça?");
          System.out.println("Qual será a sessão");
          System.out.println("Qual assento desejado?");

          break;

        default:
          break;
      }
    }
  }
}
