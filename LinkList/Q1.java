package LinkList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(2);
        ListNode secondNode = new ListNode(1);
        ListNode thridNode = new ListNode(2);
        firstNode.next = secondNode;
        secondNode.next = thridNode;

        Q1.removeDupWithTwoPointer(firstNode);
        Q1.travesalList(firstNode);
    }

    static void travesalList(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    // 使用hashset來記錄值，時間為O(n)
    static void removeDups(ListNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode prev = null;
        while(head != null) {
            if (set.contains(head.data)) {
                prev.next = head.next;
            } else {
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }

    // 使用兩個指標cur與runner
    // runner指標會刪除與cur相同data的Node
    // e.g.
    //  
    //  2  ->  1  ->  2  ->  null
    // cur
    // run

    //  2  ->  1  ->  2  ->  null
    // cur
    //        run               -> 此時 cur.data == runner.next.data，則移除第三個Node

    //  2  ->  1  ->  null
    // cur
    //                run

    // Time: O(n^2), Space: O(1)
    static void removeDupWithTwoPointer(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            ListNode runner = cur;
            while(runner.next != null) {
                if (cur.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }
}

