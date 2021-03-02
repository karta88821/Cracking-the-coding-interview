package LinkList;

public class Q3 {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thridNode = new ListNode(3);
        ListNode forthNode = new ListNode(4);
        //ListNode fifthNode = new ListNode(5);
        firstNode.next = secondNode;
        secondNode.next = thridNode;
        thridNode.next = forthNode;
        //forthNode.next = fifthNode;

        deleteNode(thridNode);
        travesalList(firstNode);
    }

    static boolean deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        ListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    static void travesalList(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
