package LinkedList;

import java.util.Stack;

/**
 * LeetCode 第25题
 * K个一组翻转链表
 */
public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用递归方法 20%
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        return core(head, k);
    }

    public ListNode core(ListNode head, int k) {
        int i = 0;
        ListNode p = head;
        ListNode result;
        Stack<ListNode> stack = new Stack();
        while (i < k && p != null) {
            stack.push(p);
            p = p.next;
            i++;
        }

        if (i == k) {
            result = stack.pop();
            ListNode q = result;
            while (!stack.isEmpty()) {
                q.next = stack.pop();
                q = q.next;
            }
            if (p != null) {
                //System.out.println("p的值是：" + p.val);
                q.next = core(p, k);
            } else {
                q.next = null;
            }
            return result;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        /*ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;*/
        ListNode result = reverseNodesInKGroup.reverseKGroup(node1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
