/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 初阶解法，交换节点的值
     * @param head
     * @return
     */
    // public ListNode swapPairs(ListNode head) {
    //     if (head == null || head.next == null) return head;

    //     ListNode tmp = head;
    //     while (tmp != null) {
    //         if (tmp.next != null) {
    //             int x = tmp.val;
    //             tmp.val = tmp.next.val;
    //             tmp.next.val = x;
    //             tmp = tmp.next.next;
    //         } else {
    //             break;
    //         }
    //     }

    //     return head;
    // }


    /**
     * 进阶解法，交换节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        /**
         * 先处理链表头
         */
        ListNode tmp = head;
        ListNode ans = tmp.next;
        head.next = ans.next;
        ans.next = head;

        ListNode before = tmp;
        tmp = tmp.next;
        while (tmp != null) {
            if (tmp.next != null) {
                ListNode n = tmp.next;
                tmp.next = n.next;
                before.next = n;
                n.next = tmp;
                before = tmp;
                tmp = tmp.next;
            } else {
                break;
            }
        }

        return ans;
    }
}
// @lc code=end

