import java.util.List;

public class PrintArray {
  public static void main(List<String[]> e) {
    for (int i = 0; i < e.size() - 2; i++) {
      System.out.println("área :" + e.get(14)[i]);
      for (int j = 0; j < e.get(i).length; j++) {
        if (j % 10 == 0 && j > 1)
          System.out.println("\n");
        if (e.get(i)[j] != "ocupado") {
          System.out.print("[" + (j + 1) + "] ");
        } else {
          System.out.print("[xx] ");
        }

      }
      System.out.println("\n");
    }
  }
}
