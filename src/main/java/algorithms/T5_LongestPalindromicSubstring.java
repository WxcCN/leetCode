package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/3
 */
public class T5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String test1 = "babad";
//        String test2 = "cbbd";
//        String test2 = "ac";
//        String test2 = "aaaa";
        String test2 = "ccc";


//        System.out.println(longestPalindrome(test1));
        System.out.println(longestPalindrome(test2));
    }

    public static String longestPalindrome(String s) {
        //指针p 记录遍历位置
        int p = 0;
        //最大长度
        int maxLen = 0;
        //最大子串
        String sr = "";

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i=p+1) {
            p = i;
            int tempLenth = 0;
            String tempS = null;
            //结尾卫判断
            if (p + 1 == s.length()) {
                if (sr.length() >= 2)
                    return sr;
                //已经是最后一位
                return String.valueOf(chars[p]);

            }
            //非回文，指针往后走
            if (p + 2 < s.length() && chars[p + 1] != chars[p] && chars[p + 2] != chars[p]) {
                p++;
            }
            if (p +2 < s.length() && chars[p + 2] == chars[p]) {
                //奇回文
                int j = 1;
                while (p - j >= 0 && p + j + 2 <= s.length() - 1 && chars[p - j] == chars[p + 2 + j]) {
                    j++;
                }
                tempLenth = 2 * j + 1;
                tempS = s.substring(p - j + 1, p + j + 2);
                if (tempLenth > maxLen) {
                    maxLen = tempLenth;
                    sr = tempS;
                }

            }
            if (chars[p + 1] == chars[p]) {
                //偶回文
                int j = 1;
                while (p - j >= 0 && p + j + 1 <= s.length() - 1 && chars[p - j] == chars[p + j + 1]) {
                    j++;
                }
                tempLenth = 2 * j;
                tempS = s.substring(p - j + 1, p + j + 1);
                if (tempLenth > maxLen) {
                    maxLen = tempLenth;
                    sr = tempS;
                }
            }
        }
        return sr;
    }

}
