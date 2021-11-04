package da_book;

public class FirstIteration {

  public static void main(String[] args) {

    //        System.out.println(3221/10);
    printOut(321);
  }

  public static void printOut(int n) {
    // print nonnegative n

    if (n >= 10) {
      printOut(n / 10);
    }
    System.out.print(n % 10); // 其实就是每次取余的时候打印
  }
}
