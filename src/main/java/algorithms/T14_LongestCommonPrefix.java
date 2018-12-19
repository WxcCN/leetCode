package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/18
 */
public class T14_LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] ss = {"flower", "flow", "flight"};
        String[] ss = {"abca","abc"};
        System.out.println(longestCommonPrefix(ss));
    }
    public static String longestCommonPrefix(String[] strs) {
        int p = -1;
        out:
        try {
            for (; p  < strs[0].length(); p++) {
                char c = strs[0].charAt(p + 1);
                for (int i = 1; i < strs.length; i++) {
                    char c1 = strs[i].charAt(p + 1);
                    if (c1 != c) {
                        break out;
                    }
                }
            }
        } catch (Exception e) {

        }
        if (p == -1) {
            return "";
        } else {
            return strs[0].substring(0, p+1);
        }

    }
}
