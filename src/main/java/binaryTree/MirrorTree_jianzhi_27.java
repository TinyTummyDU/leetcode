package binaryTree;

public class MirrorTree_jianzhi_27 {
  /*剑指 Offer 27. 二叉树的镜像
  请完成一个函数，输入一个二叉树，该函数输出它的镜像。*/

  public TreeNode mirrorTree(TreeNode root) {
    swap(root);
    return root;
  }

  public void swap(TreeNode root) {
    if (root == null) return;
    TreeNode cur = root.left;
    root.left = root.right;
    root.right = cur;
    swap(root.left);
    swap(root.right);
  }

  //    借助个临时节点来避免覆盖后找不到左（右）节点。
  public TreeNode mirrorTree1(TreeNode root) {
    if (root == null) return null;
    TreeNode tmpNode = root.left;
    root.left = mirrorTree(root.right);
    root.right = mirrorTree(tmpNode);
    return root;
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
