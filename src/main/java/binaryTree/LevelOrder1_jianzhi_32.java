package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder1_jianzhi_32 {

  // 其实就是层序遍历

  public static int[] levelOrder(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) return new int[0];
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        res.add(cur.val);
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
    }
    int[] res1 = new int[res.size()];
    for (int i = 0; i < res1.length; i++) {
      res1[i] = res.get(i);
    }
    return res1;
  }

  public static void main(String[] args) {
    TreeNode a1 = new TreeNode(3);
    TreeNode a2 = new TreeNode(9);
    TreeNode a3 = new TreeNode(20);
    a1.left = a2;
    a1.right = a3;
    TreeNode a4 = new TreeNode(15);
    TreeNode a5 = new TreeNode(7);
    a3.left = a4;
    a3.right = a5;
    //        levelOrder(a1);

    Queue<TreeNode> queue = new LinkedList<>(); // 注意null也可以被offer进队列里
    queue.offer(null);
    queue.offer(null);
    System.out.println(queue.size());
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
