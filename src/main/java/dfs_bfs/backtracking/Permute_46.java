package dfs_bfs.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute_46 {
  //    全排列
  //
  // https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/

  public List<List<Integer>> permute(int[] nums) {
    int len = nums.length;
    List<List<Integer>> res = new ArrayList();
    if (len == 0) return res;
    boolean[] used = new boolean[len];
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
