package tree.BST;

import java.util.ArrayList;
import java.util.List;

public class DifferentBST {

  // 95

  public List<TreeNode> generateTrees(int n) {

    List<TreeNode> res = new ArrayList<>();
    if (n == 0) {
      res.add(null);
    }
    res = getRes(1, n);
    return res;
  }

  public List<TreeNode> getRes(int start, int end) {

    List<TreeNode> ans = new ArrayList<TreeNode>();
    if (start > end) {
      ans.add(null);
      return ans;
    }
    if (start == end) {
      TreeNode newT = new TreeNode(start);
      ans.add(newT);
      return ans;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> l = getRes(start, i - 1);
      List<TreeNode> r = getRes(i + 1, end);
      for (TreeNode n1 : l) {
        for (TreeNode n2 : r) {
          TreeNode root = new TreeNode(i);
          root.left = n1;
          root.right = n2;
          ans.add(root);
        }
      }
    }
    return ans;
  }

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
  //
  //    public List<TreeNode> generateTrees(int n) {
  //        List<TreeNode> ans = new ArrayList<TreeNode>();
  //        if (n == 0) {
  //            return ans;
  //        }
  //        return getAns(1, n);
  //
  //    }
  //
  //    private List<TreeNode> getAns(int start, int end) {
  //        List<TreeNode> ans = new ArrayList<TreeNode>();
  //        //此时没有数字，将 null 加入结果中
  //        if (start > end) {
  //            ans.add(null);
  //            return ans;
  //        }
  //        //只有一个数字，当前数字作为一棵树加入结果中
  //        if (start == end) {
  //            TreeNode tree = new TreeNode(start);
  //            ans.add(tree);
  //            return ans;
  //        }
  //        //尝试每个数字作为根节点
  //        for (int i = start; i <= end; i++) {
  //            //得到所有可能的左子树
  //            List<TreeNode> leftTrees = getAns(start, i - 1);
  //            //得到所有可能的右子树
  //            List<TreeNode> rightTrees = getAns(i + 1, end);
  //            //左子树右子树两两组合
  //            for (TreeNode leftTree : leftTrees) {
  //                for (TreeNode rightTree : rightTrees) {
  //                    TreeNode root = new TreeNode(i);
  //                    root.left = leftTree;
  //                    root.right = rightTree;
  //                    //加入到最终结果中
  //                    ans.add(root);
  //                }
  //            }
  //        }
  //        return ans;
  //    }

}
