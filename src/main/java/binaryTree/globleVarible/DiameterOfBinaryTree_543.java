package binaryTree.globleVarible;

/**
 * @ClassName: DiameterOfBinaryTree @Description: todo @Author Yuqi Du @Date 2021/11/4 5:57
 * 下午 @Version 1.0
 */
public class DiameterOfBinaryTree_543 {

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

  // 思路：将diameter和depth结合起来
  int ans;

  public int diameterOfBinaryTree(TreeNode root) {
    ans = 0;
    dfs(root);
    return ans;
  }
  // return current node's biggest depth
  public int dfs(TreeNode root) {
    if (root == null) return 0;
    int leftDepth = dfs(root.left);
    int rightDepth = dfs(root.right);
    ans = Math.max(ans, leftDepth + rightDepth);
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
