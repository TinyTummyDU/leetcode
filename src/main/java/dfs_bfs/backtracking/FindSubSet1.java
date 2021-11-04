package dfs_bfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubSet1 {

  // 90 子集2
  // 与子集1不一样的是，原始数组里面可以有相同的数字

  public List<List<Integer>> subsetsWithDup(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>(); // 空集是所有集合的子集
    getSubSet(res, 0, temp, nums);
    return res;
  }

  private void getSubSet(List<List<Integer>> res, int start, List<Integer> temp, int[] nums) {
    res.add(new ArrayList<>(temp)); // 先把上次的子集temp加入结果集res里,注意这里千万不可以传引用
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue; // 跳过相同的元素,和上个数字相等，就跳过
      }
      temp.add(nums[i]);
      getSubSet(res, i + 1, temp, nums);
      temp.remove(temp.size() - 1);
    }
  }
}
