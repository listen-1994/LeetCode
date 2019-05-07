import java.util.ArrayList;

/**
 * LeetCode 第61题 旋转链表
 * 中等
 * 链表 双指针
 */
public class Problem61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null){
            return head;
        }
        ListNode node = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int m = k % (list.size());
        if (m == 0) {
            return head;
        }
        ListNode resultFirst = list.get(list.size() - m);
        ListNode resultLast = list.get(list.size() - m - 1);
        ListNode last = list.get(list.size() - 1);
        last.next = list.get(0);
        resultLast.next = null;
        return resultFirst;
    }
}
