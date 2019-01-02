package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/20
 */
public class T33_SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
//        int[] a = {5, 1, 2, 3, 4};
        System.out.println(search(a, 1));
    }

    public static int search(int[] nums, int target) {
        //-
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid]>nums[hi])lo = mid +1;
            else hi = mid;
        }
        System.out.println(lo);
        //-
        if (nums.length == 0) return -1;
        return recursionSearch(nums, 0, nums.length-1, target);
    }

    public static int recursionSearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;

        if (target == nums[mid]) {
            return mid;
        }
        if (start == end) {
            return -1;
        }
        //左翻
        if (nums[start] > nums[mid]) {
            //右为顺序
            if (target >= nums[mid] && target <= nums[end]) {
                return recursionSearch(nums, mid+1, end, target);
            } else {
                return recursionSearch(nums, start, mid, target);
            }
        } else {
            if (target >= nums[start] && target <= nums[mid]) {
                return recursionSearch(nums, start, mid, target);
            } else {
                return recursionSearch(nums, mid+1, end, target);
            }
        }
    }

}
