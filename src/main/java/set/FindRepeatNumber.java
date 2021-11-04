package set;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

  public int findRepeatNumber(int[] nums) {

    Set<Integer> set = new HashSet<Integer>();
    for (int num : nums) {
      if (set.contains(num)) {
        return num;
      } else {
        set.add(num);
      }
    }
    return -1;
  }

  public int findRepeatNumber1(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    int repeat = -1;
    for (int num : nums) {
      if (!set.add(num)) {
        repeat = num;
        break;
      }
    }
    return repeat;
  }
}
