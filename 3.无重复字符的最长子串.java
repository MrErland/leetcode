/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (31.48%)
 * Likes:    2446
 * Dislikes: 0
 * Total Accepted:    222.2K
 * Total Submissions: 706K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
class Solution
{
    public int lengthOfLongestSubstring(String s) 
    {
        int ans = 0;
        for (int i = 0; i < s.length(); i++)
        {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++)
            {
                if (set.contains(s.charAt(j)))
                {
                    break;
                }
                else
                {
                    set.add(s.charAt(j));
                }
            }
            ans = set.size() > ans ? set.size() : ans;
        }
        return ans;
    }
}

