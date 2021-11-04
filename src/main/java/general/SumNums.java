package general;

public class SumNums {

  public static void main(String[] args) {
    sumNums1(5);
  }

  public static int sumNums1(int n) {
    boolean x = n > 1 && (n += sumNums1(n - 1)) > 0;
    System.out.println(n);
    return n;
  }

  public int sumNums(int n) {
    if (n == 1) return 1;
    n += sumNums(n - 1);
    return n;
  }
}
