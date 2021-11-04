package sword;

public class Sword17 {

  /** 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 考虑大数越界 */
  int[] arr;

  int[] nums;
  int max_bit;

  public int[] printNumbers(int n) {
    arr = new int[n];
    nums = new int[(int) Math.pow(10, n) - 1];
    int current = 0;
    max_bit = n;
    while (increment(current)) current++;
    return nums;
  }

  public boolean increment(int current) {
    int bit = 0;
    while (bit != max_bit && arr[bit] == 9) {
      arr[bit] = 0;
      bit++;
    }
    if (bit == max_bit) return false;
    else {
      arr[bit]++;
      nums[current] = toNum();
      return true;
    }
  }

  public int toNum() {
    int num = 0;
    int base = 1;
    for (int i = 0; i < max_bit; i++) {
      num += arr[i] * base;
      base *= 10;
    }
    return num;
  }

  /*
  int[] print;
  public void printNums(int n){
      print=new int[n];
      while(incrementPrint(n));
  }

  public boolean incrementPrint(int n){
      int bit=0;
      while(bit!=n && print[bit]==9){
          print[bit]=0;
          bit++;
      }
      if(bit != n){
          print[bit]++;
          printNum(n);
          return true;
      }
      else
          return false;
  }

  public void printNum(int n){
      int cur=n-1;
      while(print[cur] == 0)
          cur--;
      for(int i=cur;i>=0;i--){
          System.out.print(print[i]);
      }
      System.out.print(" ");
  }
   */
  //    public static void main(String[] args) {
  //        Offer17 q = new Offer17();
  //        //System.out.println(Arrays.toString(q.printNumbers(1)));
  //        //q.printNums(10);
  //        q.printNumbers1(9);
  //    }
  //

  // 答案

  // 使用n位数组表示当前数字，数组下标0处为数字的最高位。数组0 1 1表示11
  public void printNumbers1(int n) {
    int[] num = new int[n];
    while (incrementArray(num)) {
      printArray(num);
    }
  }

  private boolean incrementArray(int[] num) {
    int size = num.length;
    int i = size - 1;
    while (i >= 0 && num[i] == 9) {
      num[i] = 0;
      i--;
    }
    if (i >= 0) {
      num[i]++;
      return true;
    }
    return false;
  }

  private void printArray(int[] num) {
    int size = num.length;
    int i = 0;
    while (num[i] == 0) {
      i++;
      if (i >= size) System.out.println('0');
    }

    StringBuilder sb = new StringBuilder();
    for (; i < size; i++) {
      sb.append(num[i]);
    }
    System.out.println(sb.toString());
  }
}
