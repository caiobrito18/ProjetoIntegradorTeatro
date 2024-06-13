import classes.Client;
import classes.Piece;
import classes.Theater;
import java.util.HashMap;

public class App {
    
    public void main(String[] args) {
        Theater theater = new Theater();
        HashMap<Integer, Client> clients = new HashMap<>();
        HashMap<Integer, Piece> pieces = new HashMap<>();
        Boolean rodando = true;
        pieces.put(1, new Piece("Peça 1"));
        pieces.put(2, new Piece("Peça 2"));
        pieces.put(3, new Piece("Peça 3"));

        while (rodando){
        System.out.println("""
                Olá Seja Bem vindo ao sistema de compras de Ingressos do Teatro CELK
                O que Gostaria de Fazer?
                [1]Comprar um ingresso
                [2]imprimir ingresso
                [3]ver estátisticas de vendas
                [3]Sair
                """);
            
            
            
            
            
            
            }
    }
}
