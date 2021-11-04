package search;

public class BinarySearch_33 {

  //
  // https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
  public int search(int[] nums, int target) {

    // 存在mid=start的情况，且此时mid应该被归为左侧；相反，mid = (start + end + 1) // 2，就不需要等号。
    // 怎么理解这句话呢，
    // if  nums[start]<=nums[mid] 意思就是说start-mid是一个升序的排列 当然在start!=mid时 该语句和if
    // nums[start]<nums[mid]等价
    // 如[3,1]找1  如果把mid归为后半段， 那么3，1明显不属于升序序列，当然不对，所以要把mid归为前半段

    // 反正一句话 mid要归给左侧

    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    int mid;

    while (start <= end) { // 二分查找的while很关键
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // 前半截有序
      // 如果使用mid = (lo + hi) // 2，就需要等号，
      // 此时存在mid=lo的情况，且此时mid应该被归为左侧；相反，mid = (lo + high + 1) // 2，就不需要等号。
      if (nums[start] <= nums[mid]) {
        // 如果是 [3 1] 找1 那么若上述语句不加等号的话 会找不到的

        if (nums[start] <= target && target < nums[mid]) { // 题里面默认是升序
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }
}
