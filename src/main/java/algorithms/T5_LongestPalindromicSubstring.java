package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/3
 */
public class T5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String test1 = "babad";
        String test2 = "cbbd";


        System.out.println(longestPalindrome(test1));
        System.out.println(longestPalindrome(test2));
    }

    public static String longestPalindrome(String s) {
        //指针p 记录遍历位置
        int p = 0;
        //最大长度
        int maxLen = 0;
        //最大子串
        String sr = null;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            p = i;
            int tempLenth = 0;
            String tempS = null;
            //卫判断
            if (p + 2 == s.length() - 1) {
                if ()
            }
            //非回文，指针往后走
            if (chars[p + 1] != chars[p] && chars[p + 2] != chars[p]) {
                p++;
            } else if (chars[p + 1] == chars[p]) {
                //偶回文
                int j = 1;
                while (p - j >= 0 && p + j + 1 <= s.length() - 1 && chars[p - j] == chars[p + j + 1]) {
                    j++;
                }
                tempLenth = 2 * j;
                tempS = s.substring(p - j, p + j + 1);
            } else if (chars[p + 2] == chars[p]) {
                //奇回文
                int j = 1;
                while (p - j >= 0 && p + j + 2 <= s.length() - 1 && chars[p - j] == chars[p + 2 + j]) {
                    j++;
                }
                tempLenth = 2 * j + 1;
                tempS = s.substring(p - j +1 , p + j + 1);
            }
            if (tempLenth > maxLen) {
                maxLen = tempLenth;
                sr = tempS;
            }
        }
        return sr;
    }

}
