package algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Nova wangxingchen
 * @date 2018/12/19
 */
public class T23_MergeKSortedListsV2 {

    public static void main(String[] args) {
//        ListNode a = new ListNode(1).next=new ListNode(4).next=new ListNode(5);
//        ListNode b = new ListNode(1).next=new ListNode(3).next=new ListNode(4);
//        ListNode c = new ListNode(2).next=new ListNode(6);
//        ListNode[] l = {a, b, c};
        ListNode a = null;
        ListNode b = new ListNode(-1);
        b.next=new ListNode(5);
        b.next.next=new ListNode(11);
        soutList(b);
        System.out.println("_________");
        ListNode c = null;
        ListNode d = new ListNode(1);
        d.next=new ListNode(6);
        d.next.next=new ListNode(10);
        ListNode[] l = {a,b,c,d};
        ListNode listNode = mergeKLists(l);
        soutList(listNode);


    }


    static class NodeComparetor implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparetor());
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }
        ListNode ori = new ListNode(-1);
        ListNode cur = ori;
        while (pq.size() != 0) {
            ListNode poll = pq.poll();
            if (poll.next != null) {
                pq.add(poll.next);
            }
            cur.next=poll;
            cur = cur.next;
        }
        return ori.next;
    }

    static void soutList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }




}
