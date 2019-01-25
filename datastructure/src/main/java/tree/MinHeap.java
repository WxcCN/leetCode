package tree;


import util.MyArrayUtil;

import java.util.PriorityQueue;

/**
 * @author Nova wangxingchen
 * @date 2018/12/19
 */
public class MinHeap {
    int size = 0;
    int default_lenth = 32;
    int length;
    int[] heap;

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(6);


    }
    MinHeap() {
        length = default_lenth;
        heap = new int[length];
    }

    MinHeap(int[] ori) {
    }

    public void insert(int val) {
        if (size >= length) return;
        ++size;
        heap[size] = val;
        int i = size;
        while (i / 2 > 0 && heap[i] < heap[i / 2]) {
            MyArrayUtil.intSwap(heap, i, i / 2);
            i = i / 2;
        }
    }

    public int pop() {
        int rst = heap[1];
        MyArrayUtil.intSwap(heap, 1, size);
        size--;
        heapify(heap,size,1);
        return rst;
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            //左叶子
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            MyArrayUtil.intSwap(a,i,maxPos);
            i = maxPos;
        }

    }









}
