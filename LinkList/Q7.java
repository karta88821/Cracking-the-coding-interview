package LinkList;

public class Q7 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        ListNode n10 = new ListNode(10);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n10.next = n6;
        n6.next = n4;

        Q7.travesalList(Q7.reverseList(n10));
        System.out.println("----");
        Q7.travesalList(Q7.reverseList(n1));
    }

    static ListNode hasInteraction(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return null;
        }

        TraversalRes res1 = getTraversalRes(n1);
        TraversalRes res2 = getTraversalRes(n2);

        if (!res1.tail.equals(res2.tail)) { return null; }

        ListNode p1 = n1, p2 = n2;

        if (res1.length > res2.length) {
            p1 = advance(p1, res1.length - res2.length);
        } else {
            p2 = advance(p2, res2.length - res1.length);
        }

        while(!p1.equals(p2)) {
            if (p1.equals(p2)) {
                return n1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    static TraversalRes getTraversalRes(ListNode list) {
        if (list == null) return null;
        int len = 0;
        while(list != null) {
            len++;
            list = list.next;
        }
        return new TraversalRes(list, len);
    }

    static ListNode advance(ListNode list, int steps) {
        ListNode curr = list;
        while(steps > 0 && curr != null) {
            curr = curr.next;
            steps--;
        }
        return curr;
    }
    

    static ListNode reverseList(ListNode list) {
        ListNode p = list, q = null;
        while(p != null) {
            ListNode r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        return q;
    }

    static void travesalList(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}

class TraversalRes {
    ListNode tail;
    int length;

    TraversalRes(ListNode tail, int length) {
        this.tail = tail;
        this.length = length;
    }
}
