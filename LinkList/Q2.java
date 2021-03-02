package LinkList;

public class Q2 {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thridNode = new ListNode(3);
        ListNode forthNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);
        firstNode.next = secondNode;
        secondNode.next = thridNode;
        thridNode.next = forthNode;
        forthNode.next = fifthNode;

        System.out.println(Q2.findkthToLast(firstNode, 2).data);
    }

    /*
    static int findKthToLast(ListNode head, int k) {
        ListNode cur = head;
        ListNode follow = head;

        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        while(cur.next != null) {
            cur = cur.next;
            follow = follow.next;
        }

        return follow.data;
    }
    */

    static ListNode findkthToLast(ListNode head, int k) {
        IndexWrapper indexWrapper = new IndexWrapper();
        return findkthToLast(head, indexWrapper, k);
    }

    static ListNode findkthToLast(ListNode head, IndexWrapper indexWrapper, int k) {
        if (head == null) { return null; }

        ListNode node = findkthToLast(head.next, indexWrapper, k);
        indexWrapper.index = indexWrapper.index + 1;
        if (indexWrapper.index == k) {
            return head;
        }
        return node;
    }
}

class IndexWrapper {
    int index = 0;
}