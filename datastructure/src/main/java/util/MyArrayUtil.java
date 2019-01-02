package util;

/**
 * @author Nova wangxingchen
 * @date 2018/12/25
 */
public class MyArrayUtil {
    public static void intSwap(int[] a,int start ,int end) {
        int tmp = a[start];
        a[start] = a[end];
        a[end] = tmp;
    }
}
