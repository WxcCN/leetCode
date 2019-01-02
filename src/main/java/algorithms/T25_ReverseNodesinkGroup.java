package algorithms;

import static algorithms.T23_MergeKSortedListsV2.soutList;

/**
 * @author Nova wangxingchen
 * @date 2018/12/20
 */
public class T25_ReverseNodesinkGroup {
    public static void main(String[] args) {

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
//        b.next.next=new ListNode(3);
//        b.next.next.next = new ListNode(4);
//        b.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseKGroup(b, 2);
        soutList(listNode);


    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 1) {
            return head;
        }
        ListNode ori = new ListNode(-1);
        ListNode pre = ori;
        ListNode[] lnArray = new ListNode[k];
        ListNode p = head;

        int i = 0 ;
        out:
        while (p != null) {
            i=0;
            //初始化指针
            while (i < k && p != null) {
                lnArray[i++] = p;
                p = p.next;
            }

            if (i < k) {
                break out;
            }

            pre.next = lnArray[k - 1];
            for (int j = k - 1; j > 0; j--) {
                lnArray[j].next = lnArray[j - 1];
            }
            pre = lnArray[0];
        }

        if (i == k) {
            pre.next = p;
        }else {
            pre.next = lnArray[0];
        }


        return ori.next;
    }
}
