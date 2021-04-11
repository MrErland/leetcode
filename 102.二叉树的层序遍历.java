import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;

        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        arr.add(root);
        while(arr.size() != 0) {
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            ArrayList<Integer> layer = new ArrayList<Integer>();
            for (TreeNode t : arr) {
                if (t.left != null) {
                    tmp.add(t.left);
                }
                if (t.right != null) {
                    tmp.add(t.right);
                }
                layer.add(t.val);
            }
            ans.add(layer);
            arr = tmp;
        }
        return ans;
    }
}
// @lc code=end

