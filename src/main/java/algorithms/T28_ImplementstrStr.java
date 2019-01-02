package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/20
 */
public class T28_ImplementstrStr {
    public static void main(String[] args) {
        String hello = "hello";
        String needle = "ll";
        int i = strStr(hello, needle);
        System.out.println(i);

    }

    public static int strStr(String haystack, String needle) {
//        int i = haystack.indexOf(needle);
        char[] dummy = haystack.toCharArray();
        char[] tartget = needle.toCharArray();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            while (j < needle.length() && dummy[i + j] == tartget[j]) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
