import LinkedList.ListNode;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }
        ListNode first = new ListNode(0);
        first.next = head;

        ListNode beforeM = first;
        ListNode mNode = head;
        ListNode afterN = head;
        ListNode beforePoint = first;
        ListNode point = head;
        int i = 1;
        while (point != null) {
            ListNode tmp = point.next;
            if (i < m) {
                beforeM = beforeM.next;
            }
            if (i == m) {
                mNode = point;
            }
            if (i > m && i <= n) {
                point.next = beforePoint;
            }
            if (i == n) {
                afterN = tmp;
                break;
            }
            i++;
            beforePoint = point;
            point = tmp;
        }
        beforeM.next = point;
        mNode.next = afterN;
        return first.next;
    }

    public static void main(String[] args) {
        Problem92 problem92 = new Problem92();
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        problem92.reverseBetween(head,2,4);
        ListNode.print(head);
    }
}
