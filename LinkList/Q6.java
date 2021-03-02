package LinkList;

import java.util.Stack;

class Result {
    ListNode list;
    boolean success;

    Result(ListNode list, boolean success) {
        this.list = list;
        this.success = success;
    }
}

public class Q6 {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thridNode = new ListNode(1);
        firstNode.next = secondNode;
        secondNode.next = thridNode;
        System.out.println(isPalindrome(firstNode));
    }

    static boolean isPalindrome(ListNode head) {
        int length = getListLength(head);
        Result result = getPalindromeResult(head, length);
        return result.success;
    }

    static Result getPalindromeResult(ListNode head, int length) {
        // 1->2->2->1, len = 0
        //    ^
        if (head == null || length == 0) { // List長度為even，回傳head
            return new Result(head, true);

        // 1->2->3->2->1, len = 1
        //       ^
        //       >> ^
        } else if (length == 1) { // List長度為odd，回傳head.next
            return new Result(head.next, true);
        }

        Result prevResult = getPalindromeResult(head.next, length - 2);

        // 若child call不為palindrome，則回傳錯誤的結果
        if (prevResult.list == null || !prevResult.success) {
            return prevResult;
        }

        prevResult.success = (head.data == prevResult.list.data);
        prevResult.list = prevResult.list.next;
        
        return prevResult;
    }

    static int getListLength(ListNode list) {
        int len = 0;
        while(list != null) {
            len++;
            list = list.next;
        }
        return len;
    }

    /* Stack version
    static boolean isPalindrome(ListNode list) {
        ListNode fast = list, slow = list;
        Stack<Integer> stack = new Stack<Integer>();

        //       a -> b -> c -> b -> a -> null
        // fast  ^    
        // slow  *

        // fast            ^    
        // slow       *

        // fast                      ^    
        // slow            *(at the middle)

        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast.next == null) {
            slow = slow.next;
        }

        while(slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
    */

    /* Reverse list version
    static boolean isPalindrome(ListNode<Character> list) {
        ListNode<Character> reverse = reverseAndClone(list);
        return isEqual(list, reverse);
    }

    static ListNode reverseAndClone(ListNode list) {
        ListNode p = list, q = null;

        while(p != null) {
            ListNode r = q;
            q = p;
            p = p.next;
            q.next = r;
        }

        return q;
    }

    static boolean isEqual(ListNode n1, ListNode n2) {
        while(n1 != null && n2 != null) {
            if (n1.data != n2.data) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1 == null && n2 == null;
    }
    */
}
