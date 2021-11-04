package binaryTree.BST;

import java.util.ArrayList;

/**
 * @ClassName: DeleteANodeGivenAValueInBST @Description: todo @Author Yuqi Du @Date 2021/10/30 12:19
 * 下午 @Version 1.0
 */
public class DeleteANodeGivenAValueInBST_450 {

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

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      if (root.left == null && root.right != null) {
        return root.right;
      } else if (root.right == null && root.left != null) {
        return root.left;
      } else if (root.right != null && root.left != null) {
        TreeNode cur = root.left;
        while (cur.right != null) {
          cur = cur.right;
        }
        cur.right = root.right;
        return root.left;
      } else {
        return null;
      }
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else {
      root.right = deleteNode(root.right, key);
    }
    return root;
  }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList();
  }
}
