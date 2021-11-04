package queue;

import java.util.Deque;
import java.util.LinkedList;
// double ended queue

public class MaxSlideWindow {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0) return new int[0];
    Deque<Integer> deque = new LinkedList<>();
    int[] res = new int[nums.length - k + 1];
    for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
      if (i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
      while (!deque.isEmpty() && deque.peekLast() < nums[j])
        deque.removeLast(); // 保持 deque 递减 , 减去当前队列的全部小于nums[j]的元素
      deque.addLast(nums[j]);
      if (i >= 0) res[i] = deque.peekFirst(); // 记录窗口最大值
    }
    return res;
  }
  //    可以将 “未形成窗口” 和 “形成窗口后” 两个阶段拆分到两个循环里实现。代码虽变长，但减少了冗余的判断操作。

  class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {
      if (nums.length == 0 || k == 0) return new int[0];
      Deque<Integer> deque = new LinkedList<>();
      int[] res = new int[nums.length - k + 1];
      for (int i = 0; i < k; i++) { // 未形成窗口
        while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
        deque.addLast(nums[i]);
      }
      res[0] = deque.peekFirst();
      for (int i = k; i < nums.length; i++) { // 形成窗口后
        if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
        while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
        deque.addLast(nums[i]);
        res[i - k + 1] = deque.peekFirst();
      }
      return res;
    }
  }
}
