package bit_operation;

import java.util.HashMap;
import java.util.Map;

public class MajorElement {

  //    摩尔投票法 O(n) , o(1)
  public static int majorityElement(int[] nums) {
    int vote = 0;
    int x = nums[0];
    for (int num : nums) {
      x = vote == 0 ? num : x;
      vote += num == x ? 1 : -1;
    }
    return x;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 2, 4, 2, 6, 1, 1, 2, 2, 1, 1};
    System.out.println(majorityElement(nums));
  }

  // 哈希表存储
  public int majorityElement1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        // 如果已经存在key，将值+1
        int temp = map.get(nums[i]);
        map.put(nums[i], temp + 1);
      } else map.put(nums[i], 1);
    }
    // 遍历hashmap，找出值大于数组一般的key，返回
    for (Integer i : map.keySet()) {
      if (map.get(i) * 2 > nums.length) return i;
    }
    return 0;
  }
}
