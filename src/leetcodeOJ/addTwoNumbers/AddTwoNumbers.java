package leetcodeOJ.addTwoNumbers;

import java.util.List;

/**
 * Created by Flyln on 16/7/23.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 最开始result将值赋给head，这里应该赋值的是resut的地址
 * 当result改变时，head会相应地动态增加
 *
 * 当l1直接赋给pre时，pre改变，l1也会相应的改变
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
        System.out.println(result.addTwoNumbers(l1, l2));

        System.out.println(new Solution().reverseList(l1));

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = new ListNode(5);

        System.out.println(new Solution().reverseBetween(l3,1,4));

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

    /**
     * 单链表元素反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        ListNode nxt;

        while (p != null) {
            nxt = p.next;
            p.next = pre;
            pre = p;
            p = nxt;
        }
        return pre;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead, cur = newHead;

        for (int i = 0; cur != null && i < n - m; ++i) {
            cur = cur.next;
        }

        ListNode temp = null;
        for (int i = 0; cur != null && i < m; ++i) {
            cur = cur.next;
            temp = pre;
            pre = pre.next;
        }

        ListNode nextHead = cur.next;
        cur.next = null;
        temp.next = reverse(pre);
        cur = newHead;

        for (int i = 0; cur != null && i < n; ++i) {
            cur = cur.next;
        }

        cur.next = nextHead;

        return newHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode reverse = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }

    /**
     * 234. Palindrome Linked List
     * 找出中间的位置，然后将后半部分的链表反转，然后跟前半部分的链表逐个位置比对
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode end = head;
        ListNode mid = head;

        while (end != null && end.next != null) {
            end = end.next.next;
            mid = mid.next;
        }

        if (end != null) mid = mid.next;
        mid = reverse(mid);

        while (mid != null) {
            if (mid.val != head.val) return false;
            mid = mid.next;
            head = head.next;
        }
        return true;
    }
}
