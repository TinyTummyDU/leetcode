package dfs_bfs.backtracking;

import java.util.*;

public class CombinationSum_40 {

  // 纪念一下，这道题是我自己写出来的第一道中等回溯剪枝问题

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    int len = candidates.length;
    List<List<Integer>> res = new ArrayList<>();
    if (len == 0) {
      return res;
    }
    Arrays.sort(candidates);
    Deque<Integer> path = new ArrayDeque<>();
    dfs(candidates, 0, len, target, path, res);
    return res;
  }

  public void dfs(
      int[] candidates,
      int start,
      int len,
      int target,
      Deque<Integer> path,
      List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(path));
    }
    /*   int pre = candidates[start]; //当前层元素的前一个元素*/
    for (int i = start; i < len; i++) {
      if (target - candidates[i] < 0) {
        return; // 不需要continue 因为，排序过for后面的肯定也要被剪
      }
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue; // 需要 continue，不可以return
      }
      path.add(candidates[i]);
      dfs(candidates, i + 1, len, target - candidates[i], path, res);
      path.removeLast();
    }
  }
}
