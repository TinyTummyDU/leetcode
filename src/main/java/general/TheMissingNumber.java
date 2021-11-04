package general;

public class TheMissingNumber {
  public static int missingNumber(int[] nums) {
    if (nums[0] == 0 && nums.length == 1) {
      return 1;
    }
    int before = -1;
    for (int num : nums) {
      if ((num - before) != 1) {
        return before + 1;
      } else {
        before++;
      }
    }
    return nums[nums.length - 1] + 1;
  }

  public static void main(String[] args) {
    int[] a = {0};
    System.out.println(missingNumber(a));
  }
}
