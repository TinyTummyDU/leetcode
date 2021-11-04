package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder3_jianzhi_32 {

  // 之字形 层序遍历
  //    请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
  //    第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

  // 方法2 头插法
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    dfs(res, 0, root);
    return res;
  }

  // 方法一 使用  Collections.reverse(res.get(i));
  /*为什么我用不了Collections
      public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) return res;
      dfs(res, 0, root);
      for (int i = 0; i < res.size(); i++) {
          if (i % 2 == 1) res.get(i).//0和偶数层，左到右 , 奇数层，右到左
                  Collections.reverse(res.get(i));
      }

      return res;
  }
  public void dfs(List<List<Integer>> res, int depth,TreeNode root) {
      if (res.size() == depth) {
          res.add(new ArrayList<>());
      }
      res.get(depth).add(root.val);
      if (root.left != null) dfs(res, depth + 1, root.left);
      if (root.right != null) dfs(res, depth + 1, root.right);
  }*/

  public void dfs(List<List<Integer>> res, int depth, TreeNode root) {
    if (res.size() == depth) {
      res.add(new ArrayList<>());
    }
    if (depth % 2 == 0) {
      res.get(depth).add(root.val);
    } else {
      res.get(depth).add(0, root.val); // 头插法
    }
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
