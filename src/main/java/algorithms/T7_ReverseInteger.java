package algorithms;

import java.io.UnsupportedEncodingException;

/**
 * @author Nova wangxingchen
 * @date 2018/12/10
 */
public class T7_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        String.valueOf(1);

    }

    public static  int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE/10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x/=10;
        }



        return 0;
    }
}
