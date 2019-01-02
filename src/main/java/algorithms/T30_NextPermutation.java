package algorithms;

import java.util.Arrays;

/**
 * @author Nova wangxingchen
 * @date 2018/12/20
 */
public class T30_NextPermutation {
    public static void main(String[] args) {
//        int[] a = {1, 2, 7, 4, 3, 1};
//        int[] a = {1, 2, 3};
        int[] a = {5,1,1};
        nextPermutation(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) i--;
        int j = nums.length - 1;
        if (i >= 0) {
            while (j > 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

    }

    public static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public static void reverse(int[] a, int begin) {
        int end = a.length - 1;
        while (begin < end) {
            swap(a, begin++, end--);
        }

    }
}
