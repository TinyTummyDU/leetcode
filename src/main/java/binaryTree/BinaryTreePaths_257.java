package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

  public List<String> binaryTreePaths(TreeNode root) {

    List<String> res = new ArrayList<>();
    if (root == null) return res;
    dfs(root, "", res);
    return res;
  }

  public void dfs(TreeNode root, String cur, List<String> res) {
    // 下面这五行其实都算终止条件
    if (root == null) return;
    cur += root.val; // 拼接
    if (root.left == null && root.right == null) { // 到一个叶子节点才会添加res，dfs中间肯定不会动res结果数组的
      res.add(cur);
    }
    //
    dfs(root.left, cur + "->", res);
    dfs(root.right, cur + "->", res);
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
