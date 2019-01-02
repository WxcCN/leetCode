package algorithms;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

/**
 * @author Nova wangxingchen
 * @date 2018/12/21
 */
public class T39_CombinationSum {
    public static void main(String[] args) {


        int[] a = {2, 3, 6, 7};
        List<List<Integer>> valList = combinationSum(a, 7);
        List<Integer> integers1 = valList.get(1);
        List<Integer> integers2 = valList.get(2);
        int i = integers1.hashCode();
        int i1 = integers2.hashCode();
        valList.forEach(integers -> integers.forEach(System.out::println));
    }
    static class ListComparetor implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> l1,List<Integer> l2) {
            Integer collect = l1.stream().mapToInt(Object::hashCode).sum();
            Integer collect2 = l2.stream().mapToInt(Object::hashCode).sum();
            return collect - collect2;
        }
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int candidate : candidates) {
            integerIntegerHashMap.put(candidate, candidate);

        }
        List<List<Integer>> valList = getValList(integerIntegerHashMap, target);
        List<List<Integer>> collect = valList.stream().distinct().collect(Collectors.toList());
//        Arrays.
        return valList;
    }

    private static List<List<Integer>> getValList(HashMap<Integer, Integer> integerIntegerHashMap, int target) {
        if (target < 1) {
            return null;
        }
        List<List<Integer>> rsp = new ArrayList<>();
        integerIntegerHashMap.entrySet().forEach(e -> {
            Integer key = e.getKey();
            if (key > target) {
                return;
            }
            if (key == target) {
                 rsp.add(Arrays.asList(target));
            }
            int need = target - key;
            List<List<Integer>> valList = getValList(integerIntegerHashMap, need);
            if (valList != null) {
                for (List<Integer> integers : valList) {
                    ArrayList<Integer> integers1 = new ArrayList<>(integers);
                    integers1.add(key);
                    rsp.add(integers1);
                }
            }
        });
        return rsp;

    }
//    key为值，val为标值数组
//    HashMap<Integer, List<List<Integer>>> listHashMap = new HashMap<>();
//            for (int candidate : candidates) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(candidate);
//        ArrayList<List<Integer>> valList = new ArrayList<>();
//        valList.add(arrayList);
//        listHashMap.put(candidate, valList);
//    }


//    static List<List<Integer>> getValList(HashMap<Integer, List<List<Integer>>> map, Integer target) {
//        if (target < 1) {
//            return null;
//        }
//        List<List<Integer>> funlists = map.get(target);
//        if (funlists == null) {
//            funlists = new ArrayList<>();
//        }
//        //继续查找
//        for (Map.Entry<Integer, List<List<Integer>>> listEntry : map.entrySet()) {
//            Integer key = listEntry.getKey();
//            if (key >= target) {
//                continue;
//            }
//            int needed = target - key;
//            List<List<Integer>> valList = getValList(map, needed);
//            if (valList != null) {
////                map.put(needed, valList);
//                for (List<Integer> integers : valList) {
//                    integers.add(key);
//                    funlists.add(integers);
//                }
//            }
//        }
//        return funlists.size() == 0 ? null : funlists;
//    }
}
