package sorting;

public class DecreasingSort {

    public static int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int begin, int end) {

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

        nums[begin] = nums[i];//不知道nums[begin]比pivot大还是小，就把它放前面就行（其实放后面也一样）
        nums[i] = pivot;
        quickSort(nums, i + 1, end);
        quickSort(nums, begin, i - 1);
    }

    public static void main(String[] args) {

        int[] num = {23, 45, 17, 11, 13, 89, 72, 26, 3, 17, 11, 13};

        int[] a = sortArray(num);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


    }
}
