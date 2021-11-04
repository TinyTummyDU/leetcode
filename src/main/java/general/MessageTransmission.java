package general;

public class MessageTransmission {

  // lcp 07
  private int count = 0;

  public int numWays(int n, int[][] relation, int k) {

    recur(0, 0, n, relation, k);
    return count;
  }

  // dis 表示当前传递次数， cur 表示当前小朋友
  public void recur(int dis, int cur, int n, int[][] relation, int k) {
    if (dis > k) return;
    if (dis == k && cur == n - 1) {
      count++;
      return;
    }
    for (int i = 0; i < relation.length; i++) {
      if (relation[i][0] == cur) {
        recur(dis + 1, relation[i][1], n, relation, k);
      }
    }
  }
}
