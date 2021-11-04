package dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum_jianzhi_34_113 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    dfs(res, stack, root, 0, target);
    return res;
  }

  public void dfs(
      List<List<Integer>> res, Stack<Integer> stack, TreeNode root, int current, int target) {
    if (root == null) return;
    stack.add(root.val);
    if (current + root.val == target && root.left == null && root.right == null) {
      res.add(new ArrayList<>(stack));
    }
    dfs(res, stack, root.left, current + root.val, target);
    dfs(res, stack, root.right, current + root.val, target);
    stack.pop();
  }
}
