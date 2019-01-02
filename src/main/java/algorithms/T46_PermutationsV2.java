package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nova wangxingchen
 * @date 2018/12/24
 */
public class T46_PermutationsV2 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        List<List<Integer>> permute = permute(a);
        permute.forEach(e -> {
            System.out.println("_________");
            e.forEach(v-> System.out.print(v+","));
        });
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        // ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(nums);
        DFSPermutations(result, 0, nums);
        return result;
    }

    private static void DFSPermutations(List<List<Integer>> result, int index, int[] nums) {
        // base case
        if(index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            //ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(nums));
            result.add(list);
            System.out.println("add");
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swapPermutations( nums, index, i );
            System.out.println("index = " + index + " i = " + i);
            Arrays.stream(nums).forEach(e->{
                System.out.print(e+",");
            });
            System.out.println("start");
            DFSPermutations( result, index +1, nums);
            swapPermutations( nums, index, i );
            System.out.println("index = " + index + " i = " + i);
            Arrays.stream(nums).forEach(e->{
                System.out.print(e+",");
            });
            System.out.println("end");
        }
    }

    private static void swapPermutations(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }



}
