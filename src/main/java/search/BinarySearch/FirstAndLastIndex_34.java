package search.BinarySearch;

/**
 * @ClassName: FirstAndLastIndex_34 @Description: todo @Author Yuqi Du @Date 2021/10/29 5:23
 * 下午 @Version 1.0
 */
public class FirstAndLastIndex_34 {

  public static int[] searchRange(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int index = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] < target) {
        l = mid + 1;
      } else if (nums[mid] > target) {
        r = mid - 1;
      } else {
        index = mid;
        break;
      }
    }

    if (index == -1) {
      return new int[] {-1, -1};
    }

    // left
    l = 0;
    r = index - 1;
    int lBound = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] < target) {
        l = mid + 1;
      } else { // ==
        lBound = mid;
        r = mid - 1;
      }
    }
    // right
    l = index + 1;
    r = nums.length - 1;
    int rBound = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] > target) {
        r = mid - 1;
      } else { // ==
        rBound = mid;
        l = mid + 1;
      }
    }

    lBound = lBound == -1 ? index : lBound;
    rBound = rBound == -1 ? index : rBound;

    return new int[] {lBound, rBound};
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 6, 7, 10};
    searchRange(a, 2);
  }
}
