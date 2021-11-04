package dfs_bfs.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindSubSet {

  // 追加的递归版
  public static List<List<Integer>> subset1(int[] nums) {
    return findsubsets1(nums, nums.length - 1);
  }

  public static List<List<Integer>> findsubsets1(int[] nums, int end) {
    if (end == -1) {
      List<List<Integer>> emp = new ArrayList<>();
      emp.add(new ArrayList<Integer>());
      return emp; // 一个包含空集的Arraylist
    }
    // 先把最后一个元素拿出来
    int element = nums[end];
    List<List<Integer>> pre = findsubsets1(nums, end - 1);
    for (int i = 0, j = pre.size(); i < j; i++) {
      //            pre.add(pre.get(i)); 这样不对，只会添加一个引用
      pre.add(new ArrayList<Integer>(pre.get(i)));
      pre.get(i).add(element);
    }
    return pre;
  }

  // 追加的方法
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>(1 << nums.length); // 参数是initialCapacity

    // 空集是所有集合的子集，先加进去，也作为以后追加的起点
    res.add(new ArrayList<Integer>());

    // 每便利一个元素，就把之前的子集全部复制再追加新元素
    for (int i = 0; i < nums.length; i++) {

      // for(int j = 0 ; j<res.size(); j++) { // List的length用的是size
      for (int j = 0, k = res.size(); j < k; j++) {
        // 复制一个新的
        List<Integer> newList = new ArrayList<>(res.get(j)); // 这个参数就不是initialCapacity，是Collection
        // 再追加
        newList.add(nums[i]);
        res.add(newList);
      }
    }
    return res;
  }

  // 回溯
  public List<List<Integer>> subset2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    findsubsets2(res, path, nums, 0);
    return res;
  }

  public void findsubsets2(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
    res.add(new ArrayList<Integer>(path)); // 注意，要复制，不能直接给引用
    if (start >= nums.length) { // 可有可无，分析下
      return;
    }
    for (int i = start; i < nums.length; i++) {
      path.add(nums[i]);
      findsubsets2(res, path, nums, i + 1);
      path.remove(path.size() - 1);
    }
  }

  //
  //    public static void main(String[] args) {
  //        int[] test = {1};
  //        subSet1(test);
  //    }
}
