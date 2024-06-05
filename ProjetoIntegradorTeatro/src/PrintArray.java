public class PrintArray {
  public static void main(String[][] array) {
    for (int i = 0; i < array.length - 1; i++) {
      System.out.println("área :" + array[14][i]);
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] != "ocupado") {
          System.out.print("[" + (j + 1) + "] ");
        } else {
          System.out.print("[ xx ] ");
        }
        if (j % 9 == 0 && j > 1)
          System.out.println("\n");

      }
      System.out.println("\n");
    }
  }
}
