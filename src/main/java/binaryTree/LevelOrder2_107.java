package binaryTree;

import java.util.*;

public class LevelOrder2_107 {

  // 把102改一下，res.add改为头插法
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
      res.add(0, currentLevel); // 头插法
    }
    return res;
  }

  public List<List<Integer>> levelOrderBottom1(TreeNode root) {
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
    Collections.reverse(res);
    return res;
  }

  // dfs
  public List<List<Integer>> levelOrderBottom_dfs(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    dfs(root, 0, res);
    return res;
  }

  public void dfs(TreeNode node, int depth, List<List<Integer>> res) {
    if (node == null) {
      return;
    }
    if (depth == res.size()) {
      res.add(0, new ArrayList<>()); // 头插
    }
    res.get(res.size() - depth - 1).add(node.val); // 这里从后往前找  res.size()-depth-1 灵魂！
    dfs(node.left, depth + 1, res); // 这一句执行完 才会执行下一句
    dfs(node.right, depth + 1, res);
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
