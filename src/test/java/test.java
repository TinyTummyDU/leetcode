public class test {

  public static void main(String[] args) {
    char[] chars = {'1', 'k', 'o'};
    int[] ints = {1, 2, 3};
    kill(chars, ints);

    System.out.println(chars);
    //        char类型的数组就相当于一个字符串。

    //        因为输出流System.out是PrintStream对象，PrintStream有多个重载的println方法，
    //        其中一个就是public void println(char[] x)，
    //        直接打印字符数组的话，不像int[]等其他数组，它会直接调用这个方法来打印，因而可以打印出数组内容，而不是地址。

    System.out.println(ints[1]);
  }

  public static void kill(char[] chars, int[] ints) {
    chars[1] = 'p';
    ints[1] = 9;
  }
}
