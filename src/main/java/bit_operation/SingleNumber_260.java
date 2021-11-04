package bit_operation;

public class SingleNumber_260 {

  public static void main(String[] args) {
    // 获得单独 一位 的方法：

    // (1) Integer.highestOneBit( parameter)
    //        highestOneBit()这个静态方法是得到小于等于参数的最大2的幂

    // (2) 取反 xor &= -xor
    // diff &= -diff;
    // 取负号其实就是先取反，再加 1，需要 补码 的知识。
    // 最后再和原数相与就会保留最低位的 1。比如 1010，先取反是 0101，
    // 再加 1，就是 0110，再和 1010 相与，就是 0010 了

    System.out.println("********************************");
    System.out.println("原");
    int i = 10; // 1010 为 10
    System.out.println(Integer.toBinaryString(i));
    //       // 32bit  0  00001010
    int mid = ~i;
    System.out.println("反");
    System.out.println(Integer.toBinaryString(mid));
    System.out.println(mid);

    System.out.println("补");
    int j = -i;
    System.out.println(Integer.toBinaryString(j));
  }

  public int[] singleNumber(int[] nums) {

    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor = xor ^ nums[i];
    }

    int highestBit = Integer.highestOneBit(xor);
    int[] res = new int[2];

    for (int i : nums) {
      if ((i & highestBit) == 0) { // 注意优先级
        res[0] ^= i;
      } else {
        res[1] ^= i;
      }
    }
    return res;
  }
}
