package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nova wangxingchen
 * @date 2018/12/24
 */
public  class T47_PermutationsIIV2 {
    public  static void main(String[] args) {
//        int[] a = {1, 1, 3};
        int[] a = {2,2,1,1};
        List<List<Integer>> lists = permuteUnique(a);
        lists.forEach(e -> {
            System.out.println("_________");
            e.forEach(v-> System.out.print(v+","));
        });

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        List<Integer> chosen = new ArrayList<Integer>();
        backtrack(nums,chosen,res,used);

        return res;

    }
//   Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.

// Sort the array "int[] nums" to make sure we can skip the same value.

    // when a number has the same value with its previous, we can use this number only if his previous is used
    private static void backtrack(int[] nums,List<Integer> chosen,List<List<Integer>> res,boolean[] used){
        if(chosen.size()==nums.length) res.add(new ArrayList<Integer>(chosen));
        else{
            for(int i=0;i<nums.length;i++){
                int c=nums[i];
                if(used[i]) continue;
                if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false) continue;
                used[i]=true;
                chosen.add(c);
                backtrack(nums,chosen,res,used);
                used[i]=false;
                chosen.remove(chosen.size()-1);

            }

        }
    }

}
