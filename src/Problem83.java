import LinkedList.ListNode;

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode point = head;

        ListNode leftDelNode = head;
        ListNode rightDelNode = point;

        Integer current = head.val;


        while (point.next != null) {
            point = point.next;
            rightDelNode = point;

            if (current.compareTo(point.val) == 0) {
                leftDelNode.next = rightDelNode.next;
                continue;
            }

            if (current.compareTo(point.val) != 0) {
                leftDelNode = point;
                current = point.val;
            }
        }

        return head;
    }
}
