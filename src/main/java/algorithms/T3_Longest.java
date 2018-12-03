package algorithms;



import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Nova wangxingchen
 * @date 2018/10/31
 */
public class T3_Longest {
    public static void main(String[] args) {
        String a = "pwwkew";
        T3_Longest t3_longest = new T3_Longest();

        System.out.println(t3_longest.lengthOfLongestSubstring(a));

    }
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)||s==null){
            return 0;
        }
        int[] len = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            len[i]=getLongSubString(i,s);
        }
        int asInt = Arrays.stream(len).max().getAsInt();
        return asInt;

    }
    private int getLongSubString(int i, String s) {
        String sb = String.valueOf(s.charAt(i));

        for (int j = i+1; j < s.length(); j++) {
            if (sb.contains(String.valueOf(s.charAt(j)))) {
                return j - i ;
            }else {
                sb += s.charAt(j);
            }
        }
        return s.length()-i ;


    }
}
