package dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HasPathSum_113 {

  // 路径总和113

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<Integer> path = new ArrayDeque<>();
    dfs(res, path, root, targetSum);
    return res;
  }

  public void dfs(List<List<Integer>> res, Deque<Integer> path, TreeNode root, int targetSum) {
    if (root.val == targetSum && root.left == null && root.right == null) {
      path.offer(root.val);
      res.add(new ArrayList<>(path));
      path.removeLast(); // 这里是关键，最后一个叶子节点被加入到了path里，虽然不再递归，但是一定要记得｜｜｜弹出来｜｜｜
    } else {
      if (root.left != null) {
        path.offer(root.val);
        dfs(res, path, root.left, targetSum - root.val);
        path.removeLast();
      }
      if (root.right != null) {
        path.offer(root.val);
        dfs(res, path, root.right, targetSum - root.val);
        path.removeLast();
      }
    }
  }

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
}
