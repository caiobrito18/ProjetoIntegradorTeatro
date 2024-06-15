import java.util.HashMap;
import java.util.Scanner;

import objects.Client;
import objects.Piece;
import objects.Theater;

public class App {

    public static void main(String[] args) {
        Theater theater = new Theater();
        HashMap<String, Client> clients = new HashMap<>();
        HashMap<String, Piece> pieces = new HashMap<>();
        String cpf;
        String piece;
        String turn;
        Integer area;
        Integer seat;
        Boolean rodando = true;

        pieces.put("1", new Piece("Hamlet"));
        pieces.put("2", new Piece("Romeu e Julieta"));
        pieces.put("3", new Piece("Otelo"));
        Scanner input = new Scanner(System.in);
        Scanner cpfScanner = new Scanner(System.in);
        Scanner pieceScanner = new Scanner(System.in);
        Scanner areaScanner = new Scanner(System.in);
        Scanner turnScanner = new Scanner(System.in);
        Scanner seatScanner = new Scanner(System.in);
        Scanner buyScanner = new Scanner(System.in);
        while (rodando) {
            Integer opt;
            System.out.println("""
                    Olá Seja Bem vindo ao sistema de compras de Ingressos do Teatro CELK
                    O que Gostaria de Fazer?
                    [1]Comprar um ingresso
                    [2]imprimir ingresso
                    [3]ver estatisticas de vendas
                    [0]Sair
                    """);
            opt = input.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Insira o cpf do titular do ingresso");
                    cpf = cpfScanner.nextLine();
                    System.out.println("Qual será a peça?");
                    System.out.println("""
                            Insira somente o número da peça desejada
                            1.Hamlet
                            2.Romeu e Julieta
                            3.Otelo, o Mouro de veneza
                            """);
                    piece = pieceScanner.nextLine();
                    System.out.println("Qual será a sessão");
                    System.out.println("""
                            Insira somente o número referente ao turno desejado
                            1. Manhã
                            2. Tarde
                            3. Noite
                            """);
                    turn = turnScanner.nextLine();
                    System.out.println("Qual área deseja");
                    Methods.printAreas();
                    area = areaScanner.nextInt();
                    Methods.printArray(theater.getAreas().get(area - 1));
                    System.out.println("Qual assento desejado?");
                    seat = seatScanner.nextInt();
                    System.out.println(
                            Methods.buyTicket(cpf, piece, pieces, turn, area,
                                    clients, theater, seat));
                    continue;
                case 2:
                    System.out.println("Insira o cpf do titular do ingresso");
                    cpf = cpfScanner.nextLine();
                    String printedTicket = Methods.printTicket(cpf, clients);
                    System.out.println(printedTicket);
                    continue;
                case 3:

                    System.out.println(Methods.statistics(pieces, theater));
                    continue;
                case 4:
                    System.out.println("Quantos ingressos desejas comprar? ");
                    int amount = buyScanner.nextInt();
                    for (int i = 0; i < amount; i++) {
                        Methods.ghostBuy(clients, theater, pieces);
                    }
                    System.out.println("Ingressos comprados com sucesso");
                    continue;
                case 0:
                    rodando = false;
                    break;
                default:
                    break;
            }
            System.out.println("\n");
        }
        input.close();
        cpfScanner.close();
        areaScanner.close();
        seatScanner.close();
        turnScanner.close();
        pieceScanner.close();
        buyScanner.close();
    }
}
