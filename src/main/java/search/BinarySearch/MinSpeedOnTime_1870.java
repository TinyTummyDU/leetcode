package search.BinarySearch;

/**
 * @ClassName: search.BinarySearch.MinSpeedOnTime_1870 @Description: todo @Author Yuqi Du @Date
 * 2021/11/4 2:52 下午 @Version 1.0
 */
public class MinSpeedOnTime_1870 {

  // 1870. Minimum Speed to Arrive on Time

  //  You are given a floating-point number hour, representing the amount of time you have to reach
  // the office.
  //  To commute to the office, you must take n trains in sequential order.
  //  You are also given an integer array dist of length n,
  //  where dist[i] describes the distance (in kilometers) of the ith train ride.
  //
  //  Return the minimum positive integer speed (in kilometers per hour) that all the trains must
  // travel at
  //  for you to reach the office on time, or -1 if it is impossible to be on time.

  public static int minSpeedOnTime(int[] dist, double hour) {
    if (dist.length > Math.ceil(hour)) { // 3 == 2.7->3, 3 > 1.9->2
      return -1;
    }
    int left = 1, right = Integer.MAX_VALUE; // speed, use binary search
    while (left < right) {
      int mid = left + (right - left) / 2;
      double neededTime = 0;
      for (int i = 0; i < dist.length; i++) {
        neededTime +=
            i == dist.length - 1 ? (double) dist[i] / mid : Math.ceil((double) dist[i] / mid);
      }
      if (neededTime > hour) { // need faster
        left = mid + 1;
      } else { // see if can slower, because we need a minimum speed
        right = mid; // current speed mid is ok, so we must include mid, if write code like right =
        // mid-1, we will skip mid
      }
    }
    return left; // left == right
  }

  // without binary search, time complexity is too high.
  public int solution1(int[] dist, double hour) {
    for (int speed = 1; ; speed++) {
      double neededTime = 0;
      for (int i = 0; i < dist.length; i++) {
        if (i < dist.length - 1
            && i + 1 > hour) { // so matter how fast, could work (exclude last train)
          return -1;
        }
        neededTime +=
            i == dist.length - 1 ? (double) dist[i] / speed : Math.ceil((double) dist[i] / speed);
        System.out.println(neededTime);
        if (neededTime > hour) {
          break;
        }
      }
      if (neededTime <= hour) { // success
        return speed;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 3, 2};
    System.out.println(minSpeedOnTime(a, 2.7));
  }
}
