package algorithms;

import static algorithms.T23_MergeKSortedListsV2.soutList;

/**
 * @author Nova wangxingchen
 * @date 2018/12/19
 */
public class T24_SwapNodesinPairs {
    public static void main(String[] args) {

        ListNode b = new ListNode(1);
        b.next=new ListNode(2);
        b.next.next=new ListNode(3);
        b.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(b);
        soutList(listNode);


    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ori = new ListNode(-1);
        ListNode cur = ori;
        ori = head;
        ListNode l = head;
        ListNode r = head.next;
        while (l.next != null) {
            cur.next = r;
            l.next = r.next;
            r.next = l;
            cur = l;
            l = l.next;
            if (l==null)break;
            r = l.next;

        }
        if (l != null && r == null) {
            cur.next = l;
        }
        return ori.next;
    }
}
