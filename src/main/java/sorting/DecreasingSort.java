package sorting;

public class DecreasingSort {

  public int[] sortArray(int[] nums) {

    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  public void quickSort(int[] nums, int begin, int end) {

    if (begin >= end) { // 相等的时候，就一个元素，不需要排
      return;
    }
    int pivot = nums[begin];
    int i = begin;
    int j = end;

    while (i < j) {
      while (nums[j] <= pivot && i < j) {
        j--;
      }
      while (nums[i] >= pivot && i < j) {
        i++;
      }
      int swap = nums[i];
      nums[i] = nums[j];
      nums[j] = swap;
    }

    nums[begin] = nums[i];
    nums[i] = pivot;
    quickSort(nums, i + 1, end);
    quickSort(nums, begin, i - 1);
  }
}
