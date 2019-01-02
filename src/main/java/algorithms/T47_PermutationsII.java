package algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Nova wangxingchen
 * @date 2018/12/24
 */
public class T47_PermutationsII {
    public static void main(String[] args) {
//        int[] a = {1, 1, 3};
        int[] a = {2,2,1,1};
        List<List<Integer>> lists = permuteUnique(a);
        lists.forEach(e -> {
            System.out.println("_________");
            e.forEach(v-> System.out.print(v+","));
        });

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        DFSpermute(nums,res,0);
        List<List<Integer>> collect = res.stream().distinct().collect(Collectors.toList());
        return collect;
    }

    public static void DFSpermute(int[] nums, List<List<Integer>> res, int start) {
        if (start == nums.length ) {
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(collect);
        }
        for (int i = start; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            } else {
                swap(nums,start,i);
                DFSpermute(nums,res,start+1);
                swap(nums,start,i);
            }
        }
    }

    public static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

}
