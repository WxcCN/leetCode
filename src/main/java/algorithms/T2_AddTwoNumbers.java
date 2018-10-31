package algorithms;

/**
 * 第一题
 *
 * @auther Nova wangxingchen
 * @create 18/4/8
 */
public class T2_AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(23/10);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode p = result;
        ListNode a = l1;
        ListNode b = l2;
        int flag = 0;
        while (a!=null || b!= null) {
            int add1 = a == null ? 0 : a.val;
            int add2 = b == null ? 0 : b.val;
            int sum = add1 + add2 + flag;
            flag = sum >= 10? 1:0;
            int val = sum%10 ;
            ListNode temp = new ListNode(val);
            p.next = temp;
            p = temp;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (flag ==1) {
            p.next = new ListNode(1);
        }
        return result.next;
    }
}


 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

