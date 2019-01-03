package algorithms;

import java.util.Stack;

/**
 * @author Nova wangxingchen
 * @date 2019/1/3
 */
public class T678_ValidParenthesisString {
    public static void main(String[] args) {
        T678_ValidParenthesisString t678_validParenthesisString = new T678_ValidParenthesisString();
        String s = "";
        t678_validParenthesisString.checkValidString(s);
    }

    public boolean checkValidString(String s) {
        if ("".equals(s)||null==s)return ;
        int leftstack = 0;
        int startstack = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        do {
            if (chars[i] == '(') {
                leftstack++;
            } else if (chars[i] == '*') {
                startstack++;
            } else if (chars[i] == ')') {
                if (leftstack > 0) leftstack--;
                else if (startstack > 0) startstack--;
                else return false;
            }
            i++;
        } while (i < chars.length);

        int rightstack = 0;
        startstack = 0;
        do {
            if (chars[i] == ')') {
                rightstack++;
            } else if (chars[i] == '*') {
                startstack++;
            } else if (chars[i] == '(') {
                if (rightstack > 0) rightstack--;
                else if (startstack > 0) startstack--;
                else return false;
            }
            i--;
        } while (i >= 0);
        return true;


    }
}
