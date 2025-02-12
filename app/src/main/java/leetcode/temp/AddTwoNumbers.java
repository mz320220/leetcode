package temp;

import java.util.ArrayList;
import java.util.List;

/**
 * 2、两数相加
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode resultNode = new ListNode(0);
        ListNode cursor = resultNode;
        int tenPlace = 0;
        /**
         * 注意最后一位：tenPlace不为空的时候需要进入循环输出最后一位ListNode(1)
         */
        while (l1 != null || l2 != null || tenPlace != 0) {
            int sum = 0;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + tenPlace;
            tenPlace = sum / 10;
            ListNode tempNode = new ListNode(sum % 10);
            cursor.next = tempNode;
            cursor = tempNode;
        }
        while (resultNode.next != null) {
            resultNode = resultNode.next;
            System.out.print(resultNode.val);
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
