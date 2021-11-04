package dfs_bfs.postOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: FindDuplicateSubtrees_652 @Description: todo @Author Yuqi Du @Date 2021/11/2 1:40
 * 下午 @Version 1.0
 */
public class FindDuplicateSubtrees_652 {

  //    652. Find Duplicate Subtrees

  //    Given the root of a binary tree, return all duplicate subtrees.
  //    For each kind of duplicate subtrees, you only need to return the root node of any one of
  // them.
  //    Two trees are duplicate if they have the same structure with the same node values.

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

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<TreeNode> res = new ArrayList<>();
    dfs(root, map, res);

    return res;
  }

  public String dfs(TreeNode root, HashMap<String, Integer> map, ArrayList<TreeNode> res) {
    if (root == null) return "#";
    String a = root.val + "," + dfs(root.left, map, res) + "," + dfs(root.right, map, res);
    int num = map.getOrDefault(a, 0);
    map.put(a, num + 1);
    if (num == 1) {
      res.add(root);
    }
    return a;
  }
}
