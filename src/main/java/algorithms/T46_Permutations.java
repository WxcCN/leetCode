package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nova wangxingchen
 * @date 2018/12/24
 */
public class T46_Permutations {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        List<List<Integer>> permute = permute(a);
        permute.forEach(e -> {
            System.out.println("_________");
            e.forEach(v-> System.out.println(","+v));
        });
    }
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> passList = new ArrayList<>();
        return helper(nums, passList);
    }

    public static List<List<Integer>> helper(int[] a, List<Integer> pass) {

        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int val:a) {
            //如果没有遍历过
            if (!pass.contains(val)) {
                if (pass.size() == a.length - 1) {
                    return Arrays.asList(Arrays.asList(val));
                }
                ArrayList<Integer> newpass = new ArrayList<>(pass);
                newpass.add(val);
                List<List<Integer>> helper = helper(a, newpass);
                for (List<Integer> integers : helper) {
                    ArrayList<Integer> sublist = new ArrayList<>();
                    sublist.add(val);
                    sublist.addAll(integers);
                    lists.add(sublist);
                }
            }
        }
        return lists;
    }





}
