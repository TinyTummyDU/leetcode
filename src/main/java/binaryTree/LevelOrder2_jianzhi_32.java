package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder2_jianzhi_32 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    dfs(res, 0, root);
    return res;
  }

  public void dfs(List<List<Integer>> res, int depth, TreeNode root) {
    if (res.size() == depth) {
      res.add(new ArrayList<>());
    }
    res.get(depth).add(root.val);
    if (root.left != null) dfs(res, depth + 1, root.left);
    if (root.right != null) dfs(res, depth + 1, root.right);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
