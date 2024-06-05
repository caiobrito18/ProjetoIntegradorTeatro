import java.lang.reflect.Array;

public class Poltronas {
  public static String[][] poltronas() {
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

    String[][] poltronas = new String[15][];
    String[] areas = { "Plateia A", "Plateia B", "Frisa1", "Frisa2", "Frisa3", "Frisa4", "Frisa5", "Frisa6",
        "Camarote1", "Camarote2", "Camarote3", "Camarote4", "Camarote5", "Balcão Nobre" };

    poltronas[0] = plateiaA;
    poltronas[1] = plateiaB;
    poltronas[2] = frisa1;
    poltronas[3] = frisa2;
    poltronas[4] = frisa3;
    poltronas[5] = frisa4;
    poltronas[6] = frisa5;
    poltronas[7] = frisa6;
    poltronas[8] = camarote1;
    poltronas[9] = camarote2;
    poltronas[10] = camarote3;
    poltronas[11] = camarote4;
    poltronas[12] = camarote5;
    poltronas[13] = balcaoNobre;
    poltronas[14] = areas;

    // populando o array
    for (int i = 0; i < poltronas.length - 1; i++) {
      for (int j = 0; j < poltronas[i].length; j++) {
        poltronas[i][j] = "desocupado";
      }
    }

    return poltronas;
  }
}
