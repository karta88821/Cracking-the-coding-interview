package LinkList;

import java.util.Arrays;
import java.util.LinkedList;

public class Q8 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        
        System.out.println(Q8.firstLoopNode(n1).data);
    }

    static ListNode firstLoopNode(ListNode list) {
        ListNode fast = list, slow = list;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        fast = list;

        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
