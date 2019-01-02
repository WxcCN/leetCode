package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nova wangxingchen
 * @date 2018/12/26
 * 01背包问题 动态规划
 */
public class ZeroOnePackage {
    public static void main(String[] args) {

        ZeroOnePackage zeroOnePackage = new ZeroOnePackage();
        int[] a = {2,2,4,6,3};
        List<Integer> solution = zeroOnePackage.solution(a, 9);


    }


    /*回溯解法*/
    public List<Integer> solution(int[] a, int target) {
        ArrayList<Integer> integers = new ArrayList<>();
        backStack(integers,a,0,0,9);
        return integers;
    }

    private int maxW = Integer.MIN_VALUE;

    private void backStack(List e, int[] a, int index, int cw, int target) {
        if (cw == target || index == a.length) {
            if (cw > maxW) maxW = cw;
            return;
        }
        //表示不放
        backStack(e,a,index+1,cw,target);
        if (cw + a[index] <= target) {

            backStack(e,a,index+1,cw+a[index],target);
        }
    }
}
