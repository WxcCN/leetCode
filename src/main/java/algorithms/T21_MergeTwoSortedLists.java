package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/19
 */
public class T21_MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ori = new ListNode(-1);
        ListNode cur = ori;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return ori.next;
    }


}
