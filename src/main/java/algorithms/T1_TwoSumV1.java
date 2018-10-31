package algorithms;

import java.util.HashMap;

/**
 * 第一题
 *
 * @auther Nova wangxingchen
 * @create 18/4/8
 */
public class T1_TwoSumV1 {
    public static void main(String[] args) {
//        int nums[] = {2, 5, 5, 11};
        int nums[] = {-1,0,1,2, 4097, 8193};
        int target = 8194;
        T1_TwoSumV1 t1TwoSum = new T1_TwoSumV1();
        int[] ints = t1TwoSum.twoSum(nums, target);
        System.out.println(ints[0] + " " + ints[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        //初始化map
        for (int i = 0; i < nums.length; i++) {
            //key为数组值， value为下标
            hashMap.put(nums[i],i);
        }

        //求解
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i){
               return new int[]{i,hashMap.get(target-nums[i])};

           }
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}
