import java.util.List;
import java.util.Scanner;

public class Compra {
  public static void SignUp() {
    String cpf = "";
    int turno = 0, area = 0, poltrona = 0;
    List<String[]> manha, tarde, noite;

    manha = Poltronas.main();
    tarde = Poltronas.main();
    noite = Poltronas.main();
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
        manha.get(area - 1)[(poltrona - 1)] = "ocupado";
        PrintArray.main(manha);
        break;
      case 2:
        tarde.get(area - 1)[(poltrona - 1)] = "ocupado";
        PrintArray.main(manha);
        break;
      case 3:
        noite.get(area - 1)[(poltrona - 1)] = "ocupado";
        PrintArray.main(manha);
        break;
      default:
        System.out.println("A opção escolhida é inválida. Tente novamente.");
        break;
    }
    Ticket ingresso = new Ticket(cpf, null, area, poltrona, cpf)
  }

}