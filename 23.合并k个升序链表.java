/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode last = null;
        ListNode head = null;
        if (lists != null) {
            head = merger(lists, last, head);
        }
        return head;
    }

    private ListNode merger(ListNode[] lists, ListNode last, ListNode head) {
        int min_val = Integer.MAX_VALUE;
        int min_ind = -1;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min_val) {
                min_val = lists[i].val;
                min_ind = i;
            }
        }
        /**
         * 如果列表为空，说明所有链表都已经访问完
         */
        if (min_ind == -1) return head;

        /**
         * 删除当前选中的最小值的节点
         */
        lists[min_ind] = lists[min_ind].next;
    
        /**
         * 这里需要记录下链表的头部，作为返回值
         */
        if (last == null) {
            last = new ListNode(min_val, null);
            return merger(lists, last, last);
        } else {
            last.next = new ListNode(min_val, null);
            return merger(lists, last.next, head);
        }
    }
}
// @lc code=end

