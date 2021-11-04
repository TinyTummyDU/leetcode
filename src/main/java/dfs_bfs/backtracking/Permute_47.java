package dfs_bfs.backtracking;

import java.util.*;

public class Permute_47 {

  //
  // https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/

  // 这一题在「力扣」第 46 题： 全排列 的基础上增加了 序列中的元素可重复 这一条件，但要求：返回的结果又不能有重复元素。
  //    思路是：在遍历的过程中，一边遍历一遍检测，在一定会产生重复结果集的地方剪枝。
  // if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
  //        continue;
  //    }

  public List<List<Integer>> permute(int[] nums) {
    int len = nums.length;
    List<List<Integer>> res = new ArrayList();
    if (len == 0) return res;
    boolean[] used = new boolean[len];
    // 排序（升序或者降序都可以），排序是剪枝的前提
    Arrays.sort(nums);

    Deque<Integer> path = new ArrayDeque<>();
    dfs(res, path, 0, nums, used, len);
    return res;
  }

  public void dfs(
      List<List<Integer>> res,
      Deque<Integer> path,
      int depth,
      int[] nums,
      boolean[] used,
      int len) {
    if (depth == len) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < len; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      if (!used[i]) {
        path.add(nums[i]);
        used[i] = true;
        dfs(res, path, depth + 1, nums, used, len);
        // 回退
        used[i] = false;
        path.removeLast();
      }
    }
  }
}
