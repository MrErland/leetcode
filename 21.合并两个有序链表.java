/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // 第一个元素较小的链表作为基准
        ListNode nodeBase = null;
        ListNode nodeTodo = null;

        if (l1.val < l2.val) {
            nodeBase = l1;
            nodeTodo = l2;
        } else {
            nodeBase = l2;
            nodeTodo = l1;
        }
        
        ListNode ahead = nodeBase;
        ListNode nowBase = ahead.next;
        ListNode nowTodo = nodeTodo;
        while(nowBase != null) {
            while (nowTodo != null && nowBase.val >= nowTodo.val) {
                ahead.next = nowTodo;
                ListNode tmp = nowTodo.next;
                nowTodo.next = nowBase;
                ahead = nowTodo;
                nowTodo = tmp;
            }
            if (nowTodo == null) break;
            ahead = nowBase;
            nowBase = nowBase.next;
        }
        
        if (nowTodo != null) {
            ahead.next = nowTodo;
        }

        return nodeBase;
    }
}
// @lc code=end

