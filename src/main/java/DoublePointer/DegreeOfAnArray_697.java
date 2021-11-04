package DoublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DegreeOfAnArray_697 @Description: todo @Author Yuqi Du @Date 2021/10/28 4:00
 * 下午 @Version 1.0
 */
public class DegreeOfAnArray_697 {

  //  Given a non-empty array of non-negative integers nums, the degree of this array
  //  is defined as the maximum frequency of any one of its elements.
  //  Your task is to find the smallest possible length of a (contiguous)
  //  subarray of nums, that has the same degree as nums.
  //
  //        题目翻译不忍直视，我再解释一下题目要求。给一个定义 “度”：表示数组中任何相同元素最多了几次，
  //  换句话说就是你用一个哈希表去统计所有元素的出现次数，“度” 就是整个哈希表取 value 的最大值。然后题目让你求达到这个值的 最小 连续子数组长度。
  //  题目本身不难，简单的做法是先遍历一遍数组找到 “度”，然后不断滑窗找到最小。代码如下：

  public int findShortestSubArray(int[] nums) {
    int l = 0, r = 0, len = nums.length, res = len + 1;
    Map<Integer, Integer> map = new HashMap<>();
    int maxDegree = getDegree(nums);
    while (r < len) {
      map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
      r++;
      while (map.get(nums[r - 1]) == maxDegree) {
        res = Math.min(res, r - l);
        map.put(nums[l], map.get(nums[l]) - 1); // 后面可能会有另一个数字满足度，而且其最小字串还更小
        l++;
      }
    }
    return res;
  }

  public int getDegree(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      res = Math.max(res, map.get(i));
    }
    return res;
  }
}
