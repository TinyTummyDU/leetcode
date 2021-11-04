package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength_525 {

  // 525 连续数组
  // 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度

  public int findMaxLength(int[] nums) {
    int maxLength = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int counter = 0;
    map.put(counter, -1);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      if (num == 0) {
        counter--;
      } else {
        counter++;
      }
      if (map.containsKey(counter)) {
        // 处理边界问题，如果[0,1 *****],i=1的时候，counter==0,那么map取出来的是-1，这时候1-(-1)=2，长度为2，正好合适
        int preIndex = map.get(counter);
        maxLength = Math.max(maxLength, i - preIndex);
      } else {
        map.put(counter, i);
      }
    }
    return maxLength;
  }
}
