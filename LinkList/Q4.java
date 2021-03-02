package LinkList;

public class Q4 {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(3);
        ListNode secondNode = new ListNode(5);
        ListNode thridNode = new ListNode(4);
        ListNode forthNode = new ListNode(3);
        firstNode.next = secondNode;
        secondNode.next = thridNode;
        thridNode.next = forthNode;

        ListNode newList = partition(firstNode, 4);
        travesalList(newList);
    }

    // consider order
    /*
    static ListNode partition(ListNode head, int x) {
        ListNode l1, p1, l2, p2, p = head;
        l1 = p1 = new ListNode(0);
        l2 = p2 = new ListNode(0);

        while(p != null) {
            if (p.data < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        p2.next = null;
        p1.next = l2.next;

        return l1.next;
    }
    */
    static ListNode partition(ListNode node, int x) {
        ListNode head = node;
        ListNode tail = node;

        while(node != null) {
            // 先把next存起來，以免存取不到
            ListNode next = node.next;

            // <x 則放入list的前端
            if (node.data < x) {
                node.next = head;
                head = node;
            } else { // >=x 則放入list的尾端
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next = null;

        return head;
    }

    static void travesalList(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
