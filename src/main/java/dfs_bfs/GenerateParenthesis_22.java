package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis_22 {

  // 括号生成

  // https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/

  // dfs
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) return res;
    dfs(res, n, n, "");
    return res;
  }

  public void dfs(List<String> res, int l, int r, String cur) {
    if (l == 0 && r == 0) {
      res.add(cur);
      return;
    }
    // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
    if (l > r) { // 必须先剪枝
      return;
    }
    // 下面的 r>=l
    if (l > 0) {
      dfs(res, l - 1, r, cur + "(");
    }
    if (r > 0) {
      dfs(res, l, r - 1, cur + ")");
    }
  }

  // 回溯
  //    这里如果是严格按照「回溯法」的定义去做，是这样写的。
  //    大家可以比对一下，与直接使用字符串拼接在实现细节上的不同。
  //    如果对「回溯算法」很陌生的朋友，欢迎查看第 46 题题解：
  //    从全排列问题开始理解“回溯搜索”算法（深度优先遍历 + 状态重置 + 剪枝）。
  //
  //    在强调一下重点：「回溯算法」强调了在状态空间特别大的时候，只用一份状态变量去搜索所有可能的状态，
  //    在搜索到符合条件的解的时候，通常会做一个拷贝，这就是为什么经常在递归终止条件的时候，
  //    有 res.add(new ArrayList<>(path)); 这样的代码。正是因为全程使用一份状态变量，
  //    因此它就有「恢复现场」和「撤销选择」的需要。希望大家能够通过做相关的练习，熟悉遍历和回溯的算法思想。
  public List<String> generateParenthesis_backtracking(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }

    StringBuilder path = new StringBuilder();
    dfs_back(path, n, n, res);
    return res;
  }

  /**
   * @param path 从根结点到任意结点的路径，全程只使用一份
   * @param left 左括号还有几个可以使用
   * @param right 右括号还有几个可以使用
   * @param res
   */
  private void dfs_back(StringBuilder path, int left, int right, List<String> res) {
    if (left == 0 && right == 0) {
      // path.toString() 生成了一个新的字符串，相当于做了一次拷贝，这里的做法等同于「力扣」第 46 题、第 39 题
      res.add(path.toString());
      return;
    }
    // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
    if (left > right) {
      return;
    }
    if (left > 0) {
      path.append("(");
      dfs_back(path, left - 1, right, res);
      path.deleteCharAt(path.length() - 1);
    }

    if (right > 0) {
      path.append(")");
      dfs_back(path, left, right - 1, res);
      path.deleteCharAt(path.length() - 1);
    }
  }

  public List<String> generateParenthesis_bfs(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node("", n, n));
    // 总共需要拼凑的字符总数是 2 * n
    n = 2 * n;
    while (n > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curNode = queue.poll();
        if (curNode.left > 0) {
          queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
        }
        if (curNode.right > 0 && curNode.left < curNode.right) {
          queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
        }
      }
      n--;
    }

    // 最后一层就是题目要求的结果集
    while (!queue.isEmpty()) {
      res.add(queue.poll().res);
    }
    return res;
  }

  // dp
  //
  // https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/
  public List<String> generateParenthesis_dp(int n) {
    LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
    if (n == 0) return result.get(0);
    LinkedList<String> list0 = new LinkedList<String>();
    list0.add("");
    result.add(list0);
    LinkedList<String> list1 = new LinkedList<String>();
    list1.add("()");
    result.add(list1);
    for (int i = 2; i <= n; i++) {
      LinkedList<String> temp = new LinkedList<String>();
      for (int j = 0; j < i; j++) {
        List<String> str1 = result.get(j);
        List<String> str2 = result.get(i - 1 - j);
        for (String s1 : str1) {
          for (String s2 : str2) {
            String el = "(" + s1 + ")" + s2;
            temp.add(el);
          }
        }
      }
      result.add(temp);
    }
    return result.get(n);
  }

  // bfs
  class Node {
    /** 当前得到的字符串 */
    private String res;
    /** 剩余左括号数量 */
    private int left;
    /** 剩余右括号数量 */
    private int right;

    public Node(String res, int left, int right) {
      this.res = res;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return "Node{" + "res='" + res + '\'' + ", left=" + left + ", right=" + right + '}';
    }
  }
}
