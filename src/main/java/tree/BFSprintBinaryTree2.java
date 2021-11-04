package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSprintBinaryTree2 {

  public List<List<Integer>> levelOrder(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) queue.offer(root); // root为null， res为空
    //        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int num = queue.size(); // 当前层的size
      ArrayList<Integer> mid = new ArrayList<>();
      for (int i = 0; i < num; i++) {
        TreeNode cur = queue.poll();
        mid.add(cur.val);
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
      res.add(mid);
    }
    return res;
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
