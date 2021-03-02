package LinkList;

public class Q5 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(6);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(2);

    }

    /* reverse order
    static ListNode sumList(ListNode n1, ListNode n2, int carry) {
        // 代表沒東西可以加
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        int sum = carry;

        if (n1 != null) {
            sum += n1.data;
        }

        if (n2 != null) {
            sum += n2.data;
        }

        ListNode newNode = new ListNode(sum % 10);

        if (n1 != null && n2 != null) {
            ListNode sumList = sumList(n1.next, n2.next, sum >= 10 ? 1 : 0);
            newNode.next = sumList;
        }

        return newNode;
    }
    */

    static ListNode sumList(ListNode n1, ListNode n2) {
        int len1 = length(n1);
        int len2 = length(n2);

        if (len1 < len2) {
            n1 = fillLeading(n1, len2 - len1);
        } else {
            n2 = fillLeading(n2, len1 - len2);
        }

        PartialSum sum = addLists(n1, n2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return addBefore(sum.sum, 1);
        }

    }

    static PartialSum addLists(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return new PartialSum();
        }

        PartialSum sum = addLists(n1.next, n2.next);

        int val = n1.data + n2.data + sum.carry;

        ListNode full_Result = addBefore(sum.sum, val % 10);

        sum.sum = full_Result;
        sum.carry = val / 10;

        return sum;
    }

    static int length(ListNode l) {
        int len = 0;
        while(l != null) {
            len ++;
            l = l.next;
        }
        return len;
    }

    static ListNode fillLeading(ListNode list, int count) {
        if (list != null) {
            for (int i = 0; i < count; i++) {
                list = addBefore(list, 0);
            }
        }
        return list;
    }

    static ListNode addBefore(ListNode list, int val) {
        ListNode newNode = new ListNode(val);
        if (list != null) {
            newNode.next = list;
        }
        return newNode;
    }

    static void travesalList(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}

class PartialSum {
    ListNode sum = null;
    int carry = 0;
}
