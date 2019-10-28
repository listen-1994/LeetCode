import LinkedList.ListNode;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode small = new ListNode(0);
        ListNode smallPoint = small;
        ListNode big = new ListNode(0);
        ListNode bigPoint = big;

        ListNode point = head;
        while (point != null) {
            if (point.val < x) {
                smallPoint.next = new ListNode(point.val);
                smallPoint = smallPoint.next;
            }
            if (point.val >= x) {
                bigPoint.next = new ListNode(point.val);
                bigPoint = bigPoint.next;
            }

            point = point.next;
        }

        smallPoint.next = big.next;

        return small.next;
    }
}
