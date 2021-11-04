package dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SumNumbers_129 {

  //    求根节点到叶节点数字之和

  //    给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
  //    每条从根节点到叶节点的路径都代表一个数字：
  //    例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
  //    计算从根节点到叶节点生成的 所有数字之和 。
  //    叶节点 是指没有子节点的节点。

  // 小弟的版本
  public static int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    List<Integer> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    path.add(root.val);
    dfs(res, root, path);

    int answer = 0;
    for (int i : res) {
      answer += i;
    }
    return answer;
  }

  public static void dfs(List<Integer> res, TreeNode root, Deque<Integer> path) {
    if (root.left == null && root.right == null) {
      addOnePath(res, new ArrayList<>(path));
    }
    if (root.left != null) {
      path.offer(root.left.val);
      dfs(res, root.left, path);
      path.removeLast();
    }
    if (root.right != null) {
      path.offer(root.right.val);
      dfs(res, root.right, path);
      path.removeLast();
    }
  }

  public static void addOnePath(List<Integer> res, List<Integer> path) {
    int finalNum = 0;
    int size = path.size();
    for (int i = 0; i < size; i++) {
      finalNum += path.get(size - 1 - i) * Math.pow(10, i);
    }
    System.out.println(finalNum);
    res.add(finalNum);
  }

  public static void main(String[] args) {
    TreeNode a1 = new TreeNode(4);
    TreeNode a2 = new TreeNode(9);
    TreeNode a3 = new TreeNode(0);
    TreeNode a4 = new TreeNode(5);
    TreeNode a5 = new TreeNode(1);
    a1.left = a2;
    a1.right = a3;
    a2.left = a4;
    a2.right = a5;
    sumNumbers(a1);
  }

  // 大哥的版本
  public int sumNumbers1(TreeNode root) {
    return helper(root, 0);
  }

  public int helper(TreeNode root, int i) { // i代表上一步的数字
    if (root == null) return 0;
    int temp = i * 10 + root.val;
    if (root.left == null && root.right == null) return temp;
    return helper(root.left, temp) + helper(root.right, temp);
  }

  public static class TreeNode {
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
