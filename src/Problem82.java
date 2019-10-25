import LinkedList.ListNode;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode first = new ListNode(0);
        first.next = head;

        ListNode point = head;

        Integer current = head.val;

        ListNode delLeftNode = first;
        ListNode delRightNode = head;

        while (point.next != null) {
            point = point.next;
            if (current.equals(point.val)) {
                delRightNode = point;
            }
            if (!current.equals(point.val)) {
                delLeftNode = delListNode(delLeftNode, delRightNode);
                delRightNode = point;
                current = point.val;
            }
        }
        delListNode(delLeftNode, delRightNode);
        return first.next;
    }

    private ListNode delListNode(ListNode delLeftNode, ListNode delRightNode) {
        if (delLeftNode.next != delRightNode) {
            delLeftNode.next = delRightNode.next;
            return delLeftNode;
        }
        return delRightNode;
    }

    public static void main(String[] args) {
        Problem82 problem82 = new Problem82();
        ListNode head = new ListNode(1);
        ListNode point = head;
        point.next = new ListNode(1);
/*        point = point.next;
        point.next = new ListNode(1);
        point = point.next;
        point.next = new ListNode(2);
        point = point.next;
        point.next = new ListNode(3);*/
/*        point = point.next;
        point.next = new ListNode(4);
        point = point.next;
        point.next = new ListNode(5);*/
        //ListNode.print(head);
        ListNode.print(problem82.deleteDuplicates(head));
    }

}
