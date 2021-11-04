package array;

public class TwoSum {

  public static void main(String[] args) {
    int[] nums = new int[3];
    nums[0] = 3;
    nums[1] = 4;
    nums[2] = 6;
    int target = 10;

    int[] output = twoSum(nums, target);
    System.out.println(output[0]);
    System.out.println(output[1]);
    System.out.println("*****************");
    int[] nums1 = {3, 2, 5};
    int target1 = 4;
    int[] output1 = twoSum(nums1, target1);
    System.out.println(output1[0]);
    System.out.println(output1[1]);
  }

  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[] {i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
