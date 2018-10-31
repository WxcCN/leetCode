package algorithms;

import java.util.HashMap;

/**
 * 第一题
 *
 * @auther Nova wangxingchen
 * @create 18/4/8
 */
public class T1_TwoSumV4 {
    public static void main(String[] args) {
//        int nums[] = {2, 4097, 8193, 11,1};
        int nums[] = {-1,0,1,2, 4097, 8193};
        int target = 8194;
        T1_TwoSumV4 t1TwoSum = new T1_TwoSumV4();
        int[] ints = t1TwoSum.twoSum(nums, target);
        System.out.println(ints[0] + " " + ints[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        int t=4096;
        int bitMode=t-1;
        int[] temp=new int[t];
        int length=nums.length;
        int firstValue=nums[0];

        for(int i=1;i<length;i++){
            int different=target-nums[i];
            int current=nums[i];
            if(different==firstValue) {
                return new int[] {0,i};
            }
            int i1 = different & bitMode;
            int differentIndex=temp[different&bitMode];
            if(differentIndex!=0){
                return new int[] {differentIndex,i};
            }

            int currentIndex=current&bitMode;
            temp[currentIndex]=i;
        }
        return null;
    }
}
