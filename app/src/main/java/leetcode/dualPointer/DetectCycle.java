package leetcode.dualPointer;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(node1).val);
    }

    /**
     * 对于链表找环路的问题，有一个通用的解法——快慢指针（Floyd 判圈法）。
     * 给定两个指针，分别命名为slow 和fast，起始位置在链表的开头。
     * 每次fast 前进两步，slow 前进一步。如果fast可以走到尽头，那么说明没有环路；
     * 如果fast 可以无限走下去，那么说明一定有环路，且一定存在一个时刻slow 和fast 相遇。
     * 当slow 和fast 第一次相遇时，我们将fast 重新移动到链表开头，并让slow 和fast 每次都前进一步。
     * 当slow 和fast 第二次相遇时，相遇的节点即为环路的开始点。
     * <p>
     * --> 第一次相遇
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
