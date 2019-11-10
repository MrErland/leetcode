/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.20%)
 * Likes:    1354
 * Dislikes: 0
 * Total Accepted:    122.3K
 * Total Submissions: 446.5K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution 
{
    // dp
    public String longestPalindrome(String s) 
    {
        int n = s.length();
        if (n < 2)
        {
            return s;
        }
        String result = s.substring(n-1, n);
        boolean[][] dp = new boolean[n][n];
        char[] ch = s.toCharArray();
        for (int i = n - 2; i >= 0; i--)
        {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++)
            {
                dp[i][j] = (ch[i] == ch[j] && (j - i < 3 || dp[i + 1][j - 1]));
                if (dp[i][j] && j - i + 1 > result.length())
                {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}

