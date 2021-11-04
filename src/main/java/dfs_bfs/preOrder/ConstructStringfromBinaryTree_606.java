package dfs_bfs.preOrder;

/**
 * @ClassName: ConstructStringfromBinaryTree_606 @Description: todo @Author Yuqi Du @Date 2021/11/2
 * 2:02 下午 @Version 1.0
 */
public class ConstructStringfromBinaryTree_606 {

  //    Given the root of a binary tree, construct a string consists of parenthesis and integers
  // from a binary tree
  //    with the preorder traversing way, and return it.
  //    Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship
  //    between the string and the original binary tree.

  //    Input: root = [1,2,3,null,4]
  //    Output: "1(2()(4))(3)"

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

  public String tree2str(TreeNode t) {
    StringBuilder sb = new StringBuilder();
    doTree2str(t, sb);
    return sb.toString();
  }

  private void doTree2str(TreeNode t, StringBuilder sb) {
    if (t != null) {
      sb.append(t.val);
      if (t.left != null || t.right != null) { // 左边一定有括号
        sb.append('(');
        doTree2str(t.left, sb);
        sb.append(')');
        if (t.right != null) {
          sb.append('(');
          doTree2str(t.right, sb);
          sb.append(')');
        }
      }
    }
  }
}
