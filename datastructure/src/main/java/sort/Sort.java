package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Nova wangxingchen
 * @date 2018/12/11
 */
public class Sort {

    public static void main(String[] args) {
        int[] origin = {3, 2, 55, 5, 7, 1, 22, 34, 43};
        int[] sorted = Arrays.stream(origin).sorted().toArray();

//        BubbleSort(origin);
//        InsertionSort(origin);
//        SelectionSort(origin);
//        mergesort(origin);
//        quickSort(origin);
//        quickSortNoRecursion(origin);
//        bucketSort(origin);
//        bucketSortOnMap(origin);
        Arrays.stream(origin).forEach(System.out::println);

    }

    // bucket sort
    public static void bucketSort(int[] a) {
        int[] tmp = new int[60];
        //input
        for (int p : a) {
            tmp[p]++;
        }

        int p = 0;
        for (int i = 0; i < tmp.length; i++) {
            int num = tmp[i];
            for (int j = 0; j < num; j++) {
                a[p++] = i;
            }
        }

    }
//    public static void bucketSortOnMap(int[] a) {
//        Map<Integer,Integer> tmp = new HashMap();
//        for (int i = 0; i < a.length; i++) {
//            int i1 = tmp.get(a[i]) == null ? 1 : ((int) tmp.get(a[i])) + 1;
//            tmp.put(a[i], i1);
//        }
//        int p = 0;
//        for (Map.Entry<Integer,Integer> entry:tmp.entrySet()) {
//            System.out.println(entry.getKey());
//        }
//    }

// quick sort
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = quickSortPartition(a, start, end);
        quickSort(a, start, i - 1);
        quickSort(a, i + 1, end);

    }

    public static int quickSortPartition(int[] a, int p, int q) {
        while (p < q) {
            while (p < q && a[p] < a[q]) {
                q--;
            }
            swap(a, p, q);
            while (p < q && a[p] < a[q]) {
                p++;
            }
            swap(a, p, q);
        }
        return p;
    }

    //quick sort not recursion
    public static void quickSortNoRecursion(int[] a) {
        int p = 0;
        int q = a.length-1;
        Stack<Integer> stack = new Stack<>();
        //压栈，先低后高

        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            q = stack.pop();
            p = stack.pop();
            int i = quickSortPartition(a, p, q);
            if (p < i - 1) {
                stack.push(p);
                stack.push(i - 1);
            }
            if (q > i + 1) {
                stack.push(i+1);
                stack.push(q);
            }
        }


    }

//    quick sort


    //    merge start
    public static void mergesort(int[] a) {
        mergersortdevide(a, 0, a.length - 1);
    }

    public static void mergersortdevide(int a[], int p, int q) {
        if (p >= q) {
            return;
        }
        int half = (p + q) / 2;
        mergersortdevide(a, p, half);
        mergersortdevide(a, half + 1, q);

        mergeSortMerge(a, p, q);
    }

    public static void mergeSortMerge(int[] a, int p, int q) {
        int[] tmp = new int[q - p + 1];
        int half = (p + q) / 2;
        int p1 = p;
        int p2 = half + 1;
        int i = 0;
        while (i < tmp.length) {
            while (p1 <= half && p2 <= q && a[p1] <= a[p2]) {
                tmp[i] = a[p1];
                p1++;
                i++;
            }
            while (p1 <= half && p2 <= q && a[p2] < a[p1]) {
                tmp[i] = a[p2];
                p2++;
                i++;
            }
            if (p1 > half || p2 > q) {
                int start, end;
                if (p1 > half) {
                    start = p2;
                    end = q;
                } else {
                    start = p1;
                    end = half;
                }
                while (start <= end) {
                    tmp[i++] = a[start++];
                }

            }
        }
        //array copy
        for (int j = 0; j < tmp.length; j++) {
            a[p + j] = tmp[j];
        }

    }
//    merge end


    //base
    public static void BubbleSort(int[] a) {
        int n = a.length;
        for (int i = n; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static void InsertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int val = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
    }

    public static void SelectionSort(int[] a) {
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            int p = 0;
            for (int j = 1; j <= i; j++) {
                if (a[j] > a[p]) {
                    p = j;
                }
            }
            swap(a, p, i);
        }
    }


    public static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
