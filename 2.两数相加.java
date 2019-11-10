/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int div = 0;
        int mod = 0;
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        while (l1 != null || l2 != null)
        {
            int sum = 0;
            if (l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += div;
            div = sum / 10;
            mod = sum % 10;
            ans.next = new ListNode(mod);
            ans = ans.next;
        }
        if (div != 0)
        {
            ans.next = new ListNode(div);
        }
        return tmp.next;
    }
}

