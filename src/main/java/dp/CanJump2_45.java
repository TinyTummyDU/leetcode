package dp;

public class CanJump2_45 {

  //    给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
  //    数组中的每个元素代表你在该位置可以跳跃的最大长度。
  //    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
  //    假设你总是可以到达数组的最后一个位置
  //    返回最小跳跃次数

  // 左开右开
  public int jump(int[] nums) {
    int start = 0;
    int end = 1; // 这个end 是开区间
    int count = 0;

    while (end < nums.length) {
      int curMax = 0;
      for (int i = start; i < end; i++) {
        curMax = Math.max(curMax, i + nums[i]);
      }
      start = end;
      end = curMax + 1;
      count++;
    }
    return count;
  }

  // 左开右开简化版
  public int jump2(int[] nums) {
    int count = 0;
    int end = 0;
    int curMax = 0;
    for (int i = 0; i < nums.length - 1; i++) { // i其实就是完整走一遍,最后一个i不用管，到了就行
      curMax = Math.max(curMax, i + nums[i]);
      if (curMax >= nums.length - 1) return count + 1; // 提前结束吧
      if (i == end) {
        end = curMax;
        count++;
      }
    }
    return count;
  }

  // 左闭右闭
  public int jump1(int[] nums) {
    int start = 0;
    int end = 0; // 这个end 是闭区间
    int count = 0;
    while (end < nums.length - 1) { // end走到了最后一个
      int curMax = 0;
      for (int i = start; i <= end; i++) {
        curMax = Math.max(curMax, i + nums[i]);
      }
      start = end + 1;
      end = curMax;
      count++;
    }
    return count;
  }
}
