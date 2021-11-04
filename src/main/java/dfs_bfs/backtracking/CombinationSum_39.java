package dfs_bfs.backtracking;

import java.util.*;

public class CombinationSum_39 {

  // 39 要和 47 对着看
  // 注意什么时候用 used数组，什么时候用start/begin
  // 并且要注意叶子节点，无论是39还是47，都是状态，而不是选择， 选择是在边上！！！！！！
  //
  // https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int len = candidates.length;
    List<List<Integer>> res = new ArrayList<>();
    if (len == 0) {
      return res;
    }
    Arrays.sort(candidates); // 39必须升序，47升降都可
    Deque<Integer> path = new ArrayDeque<>();
    dfs1(candidates, 0, len, target, path, res);
    return res;
  }

  // 非剪枝版本
  public void dfs(
      int[] candidates,
      int start,
      int len,
      int target,
      Deque<Integer> path,
      List<List<Integer>> res) {
    // 这一步会发现有冗余，因为如果排序过，2356，target-3<0 那么target-5也一定小于0
    //            if(target-candidates[start]<0){
    //                return;
    //            } 不对，应该是path更新以后，才能执行这个减法，因此这里直接用target就行
    if (target < 0) { // 题目给的是正整数数组，如果目前的path已经小于0，说明无法再继续递归了
      return;
    }
    if (target == 0) {
      res.add(new ArrayList<>(path));
    }
    for (int i = start; i < len; i++) {
      path.add(candidates[i]);
      // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
      dfs(candidates, i, len, target - candidates[i], path, res);
      path.removeLast();
    }
  }

  // 剪枝版本,要想剪枝，无论47/39都需要事先对目标数组进行排列，但是原理不同！！！！！！想一想
  public void dfs1(
      int[] candidates,
      int start,
      int len,
      int target,
      Deque<Integer> path,
      List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(path));
    }
    for (int i = start; i < len; i++) {
      if (target - candidates[i] < 0) {
        return; // 这里break也可以，但是continue不可以哦
      }
      path.add(candidates[i]);
      // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
      dfs(candidates, i, len, target - candidates[i], path, res);
      path.removeLast();
    }
  }
}
