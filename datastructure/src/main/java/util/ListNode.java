package util;

public class ListNode<T> {
    T data;
    ListNode next;
    ListNode pre;
    ListNode hnext;

    public ListNode(T x) {
        data = x;
    }


    public static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        ListNode<Integer> integerListNode = new ListNode<>(2);
        System.out.println((ListNode.hash(2)));



    }

}