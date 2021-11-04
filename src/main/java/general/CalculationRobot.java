package general;

public class CalculationRobot {

  public static void main(String[] args) {
    String str = "A'BC";
    String[] res = str.split("'");
    for (String i : res) {
      System.out.println(i);
    }
  }

  public int calculate(String s) {

    String[] segm = s.split("");
    int x = 1;
    int y = 0;
    for (String i : segm) {
      if (i.equals("A")) {
        x = 2 * x + y;
      }
      if (i.equals("B")) {
        y = 2 * y + x;
      }
    }
    return x + y;
  }
}
