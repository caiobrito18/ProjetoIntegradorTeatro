public class App {
    public static void main(String[] args) throws Exception {
        Boolean[] plateiaA = new Boolean[25];
        Boolean[] plateiaB = new Boolean[100];
        Boolean[] frisa1 = new Boolean[5];
        Boolean[] frisa2 = new Boolean[5];
        Boolean[] frisa3 = new Boolean[5];
        Boolean[] frisa4 = new Boolean[5];
        Boolean[] frisa5 = new Boolean[5];
        Boolean[] frisa6 = new Boolean[5];
        Boolean[] camarote1 = new Boolean[10];
        Boolean[] camarote2 = new Boolean[10];
        Boolean[] camarote3 = new Boolean[10];
        Boolean[] camarote4 = new Boolean[10];
        Boolean[] camarote5 = new Boolean[10];
        Boolean[] balcaoNobre = new Boolean[50];

        Boolean[][] poltronas = new Boolean[14][];
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

        // populando o array
        for (int i = 0; i < poltronas.length; i++) {
            for (int j = 0; j < poltronas[i].length; j++) {
                poltronas[i][j] = false;
            }
        }

        // printando
        for (int i = 0; i < poltronas.length; i++) {
            for (int j = 0; j < poltronas[i].length; j++) {
                System.out.println(" " + "poltrona " + (j + 1) + " área: " + areas[i]);
            }
            System.out.print("\n");
        }
    }

}
