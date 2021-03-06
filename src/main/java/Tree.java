import java.util.HashMap;

public class Tree {

  HashMap<Integer, Integer> dic = new HashMap<>();
  int[] po;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    po = preorder;
    for (int i = 0; i < inorder.length; i++) dic.put(inorder[i], i);
    return recur(0, 0, inorder.length - 1);
  }

  // param1 代表当前树的根结点在前序中的索引
  // param2 代表当前树的在中序的左右边界索引
  public TreeNode recur(int pre_root, int in_left, int in_right) {
    if (in_left > in_right) return null;
    TreeNode root = new TreeNode(po[pre_root]);
    int i = dic.get(po[pre_root]);
    root.left = recur(pre_root + 1, in_left, i - 1);
    root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
    return root;
  }

  //    Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
