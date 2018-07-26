package algorithms;

import java.util.HashMap;

/**
 * 平时测试用
 *
 * @auther Nova wangxingchen
 * @create 2018/7/25
 */
public class TestUtil {

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = digits[val & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }
    private static String toUnsignedString0(int val) {
        // assert shift > 0 && shift <=5 : "Illegal shift value";

        char[] buf = new char[32];
        for (int i = 0; i < 32; i++) {
            buf[i] = '0' ;
        }
        formatUnsignedInt(val, 1, buf, 0, 32);
        return new String(buf);

    }


    public static void main(String[] args) {
        new HashMap<Integer, Integer>();
        final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
        final int MAXIMUM_CAPACITY = 1 << 30;
//        System.out.println(DEFAULT_INITIAL_CAPACITY);
//        System.out.println(MAXIMUM_CAPACITY);
        int n = ( 1 << 19 )+34523;
        Integer a = n >>> 1;
        System.out.println("a=" + a);
        System.out.println("a.bin=" + toUnsignedString0(a));


        System.out.println("start:" + toUnsignedString0(n));
        for (int i = 1; i < 32; i *= 2) {
            int i1 = n >>> i;
            System.out.println("i=" + i + "before=" + toUnsignedString0(n));
            System.out.println("i=" + i + "     o=" + toUnsignedString0(i1));
            n |= i1;
            System.out.println("i=" + i + "aftern=" + toUnsignedString0(n));
            System.out.println("__________________");
        }
        int b = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println("n=" + b);

    }
}
