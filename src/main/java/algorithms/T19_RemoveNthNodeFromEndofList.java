package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/19
 */
public class T19_RemoveNthNodeFromEndofList {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        if (p.next == null) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        if (p == null) {
            return head.next;
        }else {
            while (p.next != null) {
                p=p.next;
                q=q.next;
            }
            q.next = q.next.next;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
}
