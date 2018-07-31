package algorithms;

import java.util.HashMap;

/**
 * 平时测试用
 *
 * @auther Nova wangxingchen
 * @create 2018/7/25
 */
public class TestUtil3 {
    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
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
            buf[i] = '0';
        }
        formatUnsignedInt(val, 1, buf, 0, 32);
        return new String(buf);

    }


    public static void main(String[] args) {

        int h;
//        Integer key = 5;
        String key = "asdfeavewa5";
        int i1 = key.hashCode();
        h = i1;
        int i2 = h >>> 16;
        System.out.println("i1=" + toUnsignedString0(i1));
        System.out.println("i2=" + toUnsignedString0(i2));
        int i = (h) ^ i2;
        System.out.println("i =" + toUnsignedString0(i) + "  i= " + i);
        int i3 = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println("i =" + toUnsignedString0(i3) + "  i= " + i3);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(5,555555);
        System.out.println(map.size());

    }
}
