package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: BSTSerializeAndDesrialize_449 @Description: todo @Author Yuqi Du @Date 2021/11/2 2:48
 * 下午 @Version 1.0
 */
public class BSTSerializeAndDesrialize_449 {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  //  bfs
  public static String serialize_bfs(TreeNode root) {
    if (root == null) return "#";
    String res = "";
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur == null) {
        res = res + "#,";
        continue;
      }
      res = res + cur.val + ",";
      queue.add(cur.left);
      queue.add(cur.right);
    }
    return res;
  }

  public TreeNode deserialize_bfs(String data) {
    if (data.equals("#")) return null;
    String[] strings = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    for (int i = 1; i < strings.length; i++) {
      TreeNode cur = queue.poll();
      if (!strings[i].equals("#")) {
        cur.left = new TreeNode(Integer.parseInt(strings[i]));
        queue.add(cur.left);
      }
      if (!strings[++i].equals("#")) {
        cur.right = new TreeNode(Integer.parseInt(strings[i]));
        queue.add(cur.right);
      }
    }
    return root;
  }

  // preorder dfs
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "#";
    }
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserializeHelper(queue);
  }

  public TreeNode deserializeHelper(Queue<String> queue) {
    String cur = queue.poll();
    if (cur.equals("#")) {
      return null;
    }
    TreeNode newN = new TreeNode(Integer.parseInt(cur));
    newN.left = deserializeHelper(queue);
    newN.right = deserializeHelper(queue);
    return newN;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode a = new TreeNode(2);
    TreeNode b = new TreeNode(3);
    root.left = a;
    root.right = b;
    System.out.println(serialize_bfs(root));
    System.out.println(serialize(root));
  }
}
