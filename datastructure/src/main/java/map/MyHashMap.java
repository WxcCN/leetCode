package map;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nova wangxingchen
 * @date 2018/12/10
 */
public class MyHashMap {
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) {


        String key = "test";
        Integer hash =  key.hashCode();
        Integer c = hash >>> 16;
        Integer i = hash ^ c;
        System.out.println(format32(hash));
        System.out.println(format32(c));
        System.out.println(format32(i));

        hm.put(1, 1);
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap;
//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue;


        System.out.println(format32(2333));


    }

    static String format32(int i) {
        return format32(Integer.toBinaryString(i));
    }
    static String format32(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[32];
        for (int i = 0; i < 32-chars.length; i++) {
            result[i] = '0';
        }
        for (int i = 0; i < chars.length; i++) {
            result[32 - chars.length + i] = chars[i];
        }
        return new String(result);
    }





}
