package tree.binaryTree;

public class ValidateBT {
  // 1361

  int[] leftChild, rightChild;
  boolean[] visited;

  public static void main(String[] args) {
    boolean[] test = new boolean[3];
    System.out.println(test[0]);
  }

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    // 统计每个结点的父亲数：1. 若父亲数大于1则为false  2.若父亲数等于0的不是1个则为false
    int[] indegreeCnt = new int[n];
    for (int i = 0; i < n; i++) {
      if ((leftChild[i] != -1 && ++indegreeCnt[leftChild[i]] > 1)
          || (rightChild[i] != -1 && ++indegreeCnt[rightChild[i]] > 1)) {
        return false;
      }
    }
    int root = -1;
    for (int i = 0; i < n; i++) {
      if (indegreeCnt[i] == 0) {
        if (root != -1) {
          return false;
        }
        root = i;
      }
    }
    // return true;， 如果在这里就return，0<--->1 会被判断为true，其实这种没有根节点（入度为0）的，这里root就为-1，
    // 然后走到下面的时候，就根本无法开始bfs，自然就没有节点会被访问到，那么就是false

    // 上面的判断可以解决单个连通域的树判断、及部分多连通域情况
    // 例如下面的情况无法判断，需要再判断连通域的个数。从root一遍dfs之后，若存在结点未被访问说明多个连通域。
    // 1 <--- 0 <--->  2， 4 --->3
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    visited = new boolean[n];
    dfs(root);
    for (boolean v : visited) {
      if (!v) {
        return false;
      }
    }
    return true;
  }

  private void dfs(int v) {
    if (v == -1) {
      return;
    }
    visited[v] = true;
    dfs(leftChild[v]);
    dfs(rightChild[v]);
  }
}
