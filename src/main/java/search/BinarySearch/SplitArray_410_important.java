package search.BinarySearch;

/**
 * @ClassName: SplitArray_410_important @Description: todo @Author Yuqi Du @Date 2021/10/29 1:08
 * 下午 @Version 1.0
 */
public class SplitArray_410_important {

  public static int splitArray(int nums[], int m) {
    int left = 0;
    int right = 0;
    for (int i = 0; i < nums.length; i++) {
      left = Math.max(left, nums[i]);
      right += nums[i];
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (split(nums, mid) <= m) {
        right = mid;
      } else { // 分的多了，那就得再放大mid
        left = mid + 1;
      }
    }
    return left;
  }

  public static int split(int nums[], int x) {
    int res = 1;
    int cur = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((cur + nums[i]) > x) {
        cur = nums[i]; // new start
        res++;
      } else {
        cur += nums[i];
      }
    }
    System.out.println(x);
    System.out.println("res " + res);
    return res;
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 3, 4, 5};
    int[] b = new int[] {7, 2, 5, 10, 8};

    System.out.println(splitArray(b, 2));
  }
}
