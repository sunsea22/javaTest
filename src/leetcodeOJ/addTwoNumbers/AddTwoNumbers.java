package leetcodeOJ.addTwoNumbers;

/**
 * Created by Flyln on 16/7/23.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 最开始result将值赋给head，这里应该赋值的是resut的地址
 * 当result改变时，head会相应地动态增加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution result = new Solution();
        ListNode l1  = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(result.addTwoNumbers(l1,l2));
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;
        int flag = 0;

        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + flag;
            result.next = new ListNode(sum % 10);
            flag = sum / 10;
            result = result.next;
        }

        if (flag > 0) {
            result.next = new ListNode(flag);
        }
        return head.next;
    }
}
