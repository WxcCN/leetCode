package algorithms;

/**
 * @author Nova wangxingchen
 * @date 2018/12/19
 */
public class T23_MergeKSortedLists {

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
        ListNode c = null;
        ListNode d = new ListNode(1).next=new ListNode(6).next=new ListNode(10);
        ListNode[] l = {a,b,c,d};
        ListNode listNode = mergeKLists(l);


    }

    static void soutList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (lists.length == 0) {
            return null;
        }

        return sort(lists, 0, length - 1);

    }

    private static ListNode sort(ListNode[] list, int begin, int end) {
        if (begin == end) {
            return list[begin];
        }
        int div = (end + begin) / 2;
        ListNode l1 = sort(list, begin, div);
        ListNode l2 = sort(list, div + 1, end);
        ListNode res = mergeTwoLists(l1, l2);
        list[begin] = res;
        return res;
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
