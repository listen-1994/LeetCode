package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void print(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode point = head;
        while (point.next != null) {
            System.out.print(point.val + "->");
            point = point.next;
        }
        System.out.println(point.val);
    }

    public static ListNode createListNode(Integer... integers) {
        ListNode first = new ListNode(0);
        ListNode point = first;
        for (Integer integer : integers) {
            point.next = new ListNode(integer);
            point = point.next;
        }
        return first.next;
    }

}
