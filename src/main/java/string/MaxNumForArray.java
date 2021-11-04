package string;

import java.util.Arrays;

public class MaxNumForArray {
  // 179

  public String largestNumber(int[] nums) {
    String[] str = new String[nums.length];
    for (int i = 0; i < str.length; i++) {
      str[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(str, (x, y) -> (y + x).compareTo(x + y));

    // If, after being sorted, the largest number is `0`, the entire number
    // is zero.
    // 找最大值和剑指45不一样的就是，前导0不可以有，比如0，0， 最后返回的不能是"00" 而是"0"
    // 只要经过sort以后，如果第一位是0，那么肯定其他都是0，因为是最大数排序，所以直接返回0al
    if (str[0].equals("0")) {
      return "0";
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (String s : str) {
      stringBuilder.append(s);
    }
    return stringBuilder.toString();
  }
}
