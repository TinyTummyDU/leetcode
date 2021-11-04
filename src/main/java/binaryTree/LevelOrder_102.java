package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {

  // 二叉树的层序遍历

  // bfs
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      while (size > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
        currentLevel.add(node.val);
        size--;
      }
      res.add(currentLevel);
    }
    return res;
  }

  // dfs
  public List<List<Integer>> levelOrder_dfs(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    dfs(res, root, 0);
    return res;
  }

  public void dfs(List<List<Integer>> res, TreeNode root, int depth) {
    if (res.size() == depth) {
      res.add(new ArrayList<>());
    }
    res.get(depth).add(root.val); // 添加当前元素这一步，非常重要
    if (root.left != null) dfs(res, root.left, depth + 1);
    if (root.right != null) dfs(res, root.right, depth + 1);
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
