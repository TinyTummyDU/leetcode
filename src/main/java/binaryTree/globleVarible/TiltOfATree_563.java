package binaryTree.globleVarible;

/**
 * @ClassName: TileOfATree @Description: todo @Author Yuqi Du @Date 2021/11/8 2:43 下午 @Version 1.0
 */
public class TiltOfATree_563 {

  // 和543 非常像，都是对全局变量的使用
  // 需要return的值是顺便更新的

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

  public int findTilt(TreeNode root) {
    if (root == null) return 0;
    return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    // 这里会冗余计算sum
  }

  public int sum(TreeNode root) {
    if (root == null) return 0;
    return root.val + sum(root.left) + sum(root.right);
  }

  int tilt;

  // O(n) O(n)
  public int findTilt1(TreeNode root) {
    traverse(root);
    return tilt;
  }

  private int traverse(TreeNode root) {
    if (root == null) return 0;
    // post order
    int l = traverse(root.left);
    int r = traverse(root.right);
    tilt += Math.abs(l - r);
    return l + r + root.val; // 类似于上面的sum
  }
}
