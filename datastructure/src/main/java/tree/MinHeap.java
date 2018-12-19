package tree;

import java.util.PriorityQueue;

/**
 * @author Nova wangxingchen
 * @date 2018/12/19
 */
public class MinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        priorityQueue.add(3);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }


}
