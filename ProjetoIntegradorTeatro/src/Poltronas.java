import java.util.ArrayList;
import java.util.List;

public class Poltronas {
  public static List<String[]> main() {
    String[] plateiaA = new String[25];
    String[] plateiaB = new String[100];
    String[] frisa1 = new String[5];
    String[] frisa2 = new String[5];
    String[] frisa3 = new String[5];
    String[] frisa4 = new String[5];
    String[] frisa5 = new String[5];
    String[] frisa6 = new String[5];
    String[] camarote1 = new String[10];
    String[] camarote2 = new String[10];
    String[] camarote3 = new String[10];
    String[] camarote4 = new String[10];
    String[] camarote5 = new String[10];
    String[] balcaoNobre = new String[50];

    List<String[]> poltronas = new ArrayList<>();
    String[] areas = { "Plateia A", "Plateia B", "Frisa1", "Frisa2", "Frisa3", "Frisa4", "Frisa5", "Frisa6",
        "Camarote1", "Camarote2", "Camarote3", "Camarote4", "Camarote5", "Balcão Nobre" };
    String[] valores = { "40", "60", "120", "120", "120", "120", "120", "120", "80", "80", "80", "80", "80", "250" };
    poltronas.add(plateiaA);
    poltronas.add(plateiaB);
    poltronas.add(frisa1);
    poltronas.add(frisa2);
    poltronas.add(frisa3);
    poltronas.add(frisa4);
    poltronas.add(frisa5);
    poltronas.add(frisa6);
    poltronas.add(camarote1);
    poltronas.add(camarote2);
    poltronas.add(camarote3);
    poltronas.add(camarote4);
    poltronas.add(camarote5);
    poltronas.add(balcaoNobre);
    poltronas.add(areas);
    poltronas.add(valores);

    // populando o array
    for (int i = 0; i < poltronas.size() - 2; i++) {
      for (int j = 0; j < poltronas.get(i).length; j++) {
        poltronas.get(i)[j] = "desocupado";
      }
    }
    return poltronas;
  }
}
