package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsStraight {

  public static void main(String[] args) {

    int[] test = {0, 0, 0, 0, 0};
    System.out.println(isStraight_set(test));
  }

  // 顺子的两个条件：
  // 1 除大小王外，所有牌 无重复
  // 2 max - min <5 大小王除外

  // 第一种方法 使用集合+遍历
  // 时间O(N) ，空间O(N)
  public static Boolean isStraight_set(int[] nums) {
    Set<Integer> toolSet = new HashSet<>();
    int min = 14, max = 0; // 让遍历时候第一遍最大同时为min和max即可
    for (int num : nums) {
      if (num == 0) {
        continue;
      } // 跳过大小王
      if (!toolSet.contains(num)) {
        toolSet.add(num);
      } else {
        return false; // 又重复则不可
      }
      min = Math.min(num, min);
      max = Math.max(num, max);
    }
    return max - min < 5; // max和min调换一开始，可以保证全是0，也是顺子
  }

  // 第二种方法 使用排序+遍历
  // 空间O(1) 时间O(NlogN)
  public static Boolean isStraight_sort(int[] nums) {
    int joker = 0;
    Arrays.sort(nums);
    for (int i = 0; i <= 4; i++) {
      // 大小王在最前面，大小王以后不可以有重复的牌
      if (nums[i] == 0) {
        joker++;
      } else { // 只要进入else，说明后面没有joker了，因为已经排序过了
        if (nums[i] == nums[i + 1]) {
          return (false);
        }
      }
    }
    return nums[4] - nums[joker] < 5;
  }
  // java的Arrays类中有一个sort()方法，该方法是Arrays类的静态方法，在需要对数组进行排序时，非常的好用

}
