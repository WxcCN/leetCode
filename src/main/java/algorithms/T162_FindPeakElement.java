package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2019/1/19
 */
public class T162_FindPeakElement {
    public static void main(String[] args) {
        T162_FindPeakElement t162_findPeakElement = new T162_FindPeakElement();
//        int[] a = {1, 2, 1, 3, 5, 6, 4};
        int[] a = {1, 2, 1, 3, 5, 6, 7};
        System.out.println(t162_findPeakElement.findPeakElement(a));

    }
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
