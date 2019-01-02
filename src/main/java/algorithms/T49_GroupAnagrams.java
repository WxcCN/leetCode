package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Nova wangxingchen
 * @date 2018/12/25
 */
public class T49_GroupAnagrams {
    public static void main(String[] args) {
//        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] a = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        String[] a = {"duh", "ill"};
        List<List<String>> lists = groupAnagrams(a);
        lists.forEach(e->{
            System.out.println("_____");
            e.forEach(v->{
            System.out.println(v+",");
        });
        });
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        //key是hash，val是list
        HashMap<Integer, List<String>> rsmap = new HashMap<>();
        for (String s : strs) {
            int key = myHashCode(s);
            List<String> listEntry = rsmap.get(key);
            if (listEntry == null) {
                ArrayList<String> slist = new ArrayList<>();
                slist.add(s);
                rsmap.put(key, slist);
            } else {
                listEntry.add(s);
            }
        }
        ArrayList<List<String>> rslist = new ArrayList<>();
        rsmap.forEach((k,v)->{rslist.add(v);});
        return rslist;
    }

    //无冲突的hash算法
    public static int myHashCode(String a) {
        char[] chars = a.toCharArray();
        int sum = 0;
        for (char c : chars) {
            int i = c ^ c << 6 + c;
            System.out.println(Math.abs(i));
            sum+=i;

        }
        System.out.println("s = " + a  + "  sum = " + sum);
        return sum;
    }
}
