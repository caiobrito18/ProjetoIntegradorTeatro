import java.util.Scanner;

public class Compra {
  public static void SignUp() {
    String cpf = "";
    int turno = 0, area = 0, poltrona = 0;
    String[][] manha, tarde, noite;

    manha = Poltronas.poltronas();
    tarde = Poltronas.poltronas();
    noite = Poltronas.poltronas();
    Scanner input = new Scanner(System.in);

    System.out.println("insira o cpf do titular do ingresso: ");
    cpf = input.nextLine();

    System.out.println("Escolha o horário para a sessão: ");
    turno = input.nextInt();

    System.out.println("Escolha a área desejada: ");
    area = input.nextInt();

    System.out.println("Escolha a poltrona desejada: ");
    poltrona = input.nextInt();

    switch (turno) {
      case 1:
        manha[(area - 1)][(poltrona - 1)] = "ocupado";
        PrintArray.main(manha);
        break;
      case 2:
        tarde[(area - 1)][(poltrona - 1)] = "ocupado";
        PrintArray.main(tarde);
        break;
      case 3:
        noite[(area - 1)][(poltrona - 1)] = "ocupado";
        PrintArray.main(noite);
        break;
      default:
        System.out.println("A opção escolhida é inválida. Tente novamente.");
        break;
    }
  }
}