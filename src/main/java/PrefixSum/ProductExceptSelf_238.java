package PrefixSum;

public class ProductExceptSelf_238 {

  //    238. 除自身以外数组的乘积
  //    给你一个长度为n的整数数组nums，其中n > 1，
  //    返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。

  // 示例
  //    输入: [1,2,3,4]
  //    输出: [24,12,8,6]

  // 思路：不用除法，那就用乘法，上三角下三角正好空出对角线！
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    int below = 1;
    int top = 1;

    for (int i = 0; i < len; i++) {
      res[i] = below;
      below *= nums[i];
    }
    for (int j = len - 1; j >= 0; j--) {
      res[j] *= top;
      top *= nums[j];
    }
    return res;
  }
}
