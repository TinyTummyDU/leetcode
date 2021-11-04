package array;

public class ExchangeOddEven {

  // 首尾双指针

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int i = 1;
    System.out.println(nums[++i]);
    System.out.println(nums[i]);
  }

  public int[] exchange1(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      if ((nums[left] & 1) != 0) {
        left++;
        continue;
      }

      if ((nums[right] & 1) != 1) {
        right--;
        continue;
      }
      int swap = nums[left];
      nums[left] = nums[right];
      nums[right] = swap;
      left++;
      right++;
    }
    return nums;
  }

  // 快慢双指针
  public int[] exchange2(int[] nums) {

    int low = 0;
    int fast = 0;
    while (fast < nums.length) {
      if ((nums[fast] & 1) != 0) {
        int swap = nums[low];
        nums[low] = nums[fast];
        nums[fast] = swap;
        low++;
      }
      fast++;
    }
    return nums;
  }

  // myself
  public int[] exchange(int[] nums) {

    int[] res = new int[nums.length];
    int left = 0;
    int right = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 1) {
        res[left] = nums[i];
        left++;
      } else {
        res[right] = nums[i];
        right--;
      }
    }
    return res;
  }
}
