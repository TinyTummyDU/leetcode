package general;

import java.util.Scanner;

public class SingleNumbers {

  //    一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

  // 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

  public static void main(String[] args) {
    int a = 1;
    a <<= 2;
    System.out.println(a);
    System.out.println(Integer.toBinaryString(Integer.valueOf(a)));
    System.out.println(Integer.toBinaryString(a));
    //
    Scanner input = new Scanner(System.in);
    int length = input.nextInt(); // 输入二进制数据
    System.out.println("输入:" + length);
    System.out.println(
        "输入的数字如果是二进制 ， 我们转化为10进制(不是二进制，使用parseInt会报错饿):"
            + Integer.parseInt(String.valueOf(length), 2));

    //        int length10 =Integer.valueOf(String.valueOf(length),10);//转换成十进制
    //        System.out.println(length10);
  }

  // 分组异或
  public int[] singleNumbers(int[] nums) {

    // 先将所有的数异或了
    int k = 0;

    for (int num : nums) {
      k ^= num;
    }
    // 找到一个位 是 这两个数不同的
    int mask = 1;
    while ((mask & k) == 0) {
      mask <<= 1;
    }

    int a = 0;
    int b = 0;

    for (int num : nums) {
      if ((num & mask) == 0) {
        a ^= num;
        // 0 异或 一个数 = 这个数
        // 相同的数两次一定在一个组里
      } else {
        b ^= num;
      }
    }
    return new int[] {a, b};
  }

  //    def singleNumbers(self, nums):
  //    ret, index = 0, 0
  //            for n in nums:
  //    ret ^= n
  //        # 找从右向左数第几位不同，也就是第index位
  //        # 这一步其实可以根据n & (-n)的快捷方式获得，不过对位运算掌握不是那么熟练的话，记结论容易忘，不如理解实质
  //        while ret & 1 == 0:
  //    index += 1
  //    ret >>= 1
  //    r1, r2 = 0, 0
  //            for n in nums:
  //            if (n >> index) & 1 == 0:
  //    r1 ^= n
  //            else:
  //    r2 ^= n
  //        return [r1, r2]

  public int[] singleNumbers1(int[] nums) {

    int res = 0;
    int index = 0; // 第几位不同-1 = index

    for (int num : nums) {
      res ^= num;
    }
    while ((res & 1) == 0) {
      index++;
      res >>= 1;
    }

    int g1 = 0, g2 = 0;
    for (int num : nums) {
      int cur = num >> index;
      if ((cur & 1) == 0) {
        g1 ^= num;
      } else {
        g2 ^= num;
      }
    }
    return new int[] {g1, g2};
  }
}
