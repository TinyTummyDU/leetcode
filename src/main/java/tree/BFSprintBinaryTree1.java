package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSprintBinaryTree1 {
  // 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
  // 返回一个数组

  public int[] levelOrder(TreeNode root) {

    //        if(root==null)return null;
    if (root == null) return new int[0]; // 具体看他要求什么，返回什么
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<TreeNode> arrayList = new ArrayList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      arrayList.add(current);
      if (current.left != null) queue.offer(current.left);
      if (current.right != null) queue.offer(current.right);
    }
    int[] res = new int[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++) {
      res[i] = arrayList.get(i).val;
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
