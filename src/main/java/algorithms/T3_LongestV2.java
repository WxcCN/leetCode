package algorithms;


import java.util.Arrays;

/**
 * @author Nova wangxingchen
 * @date 2018/10/31
 */
public class T3_LongestV2 {
    public static void main(String[] args) {
//        String a = "pwwkew";
        String a = "acabaa";
        T3_LongestV2 t3_longest = new T3_LongestV2();

        System.out.println(t3_longest.lengthOfLongestSubstring(a));

    }

    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        //返回值
        int res = 0;
        //指针
        int left = -1;

        //遍历
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (m[c]==)
//
//
//
//        }
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
            System.out.println("");
        }
        return res;
//        return 0;


    }

}
