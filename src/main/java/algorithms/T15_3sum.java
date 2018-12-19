package algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Nova wangxingchen
 * @date 2018/12/18
 */
public class T15_3sum {
    public static void main(String[] args) {

//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0,0,0,0};
//        int[] nums = {1,1,-2};

        int[] nums = {2,0,-2,-5,-5,-3,2,-4};
        threeSum(nums).stream().forEach(e -> {
            e.forEach(System.out::println);
            System.out.println("__________");
        });

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
//        int[] ints = Arrays.stream(nums).sorted().toArray();
        int[] ints = nums;
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; ints[i] <= 0 && i<ints.length -2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int mark = ints[i];
            int need = 0 - mark;
            int p = i + 1;
            int q = ints.length - 1;
            while (p < q ) {
                int val = ints[p] + ints[q];
                if (val < need) p++;
                else if (val > need) q--;
                else {
                    int[] a = {ints[i], ints[p], ints[q]};
                    List<Integer> integers1 = Arrays.asList(ints[i], ints[p], ints[q]);
                    if (!hashSet.contains(integers1)) {
                        hashSet.add(integers1);
                    }
                    p++;q--;
                }
            }
        }
        return hashSet.parallelStream().collect(Collectors.toList());
    }
}
