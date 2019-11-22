/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (35.17%)
 * Likes:    775
 * Dislikes: 0
 * Total Accepted:    150.5K
 * Total Submissions: 425.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        StringBuilder bStringBuilder = new StringBuilder();
        if (strs == null)
        {
            return null;
        }
        if (strs.length == 0)
        {
            return "";
        }

        String first = strs[0];
        for (int i = 0; i < first.length(); i++)
        {
            boolean flag = true;
            for (String str : strs)
            {
                if (i >= str.length() || str.charAt(i) != first.charAt(i))
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                bStringBuilder.append(first.charAt(i));
            }
            else
            {
                return bStringBuilder.toString();
            }
        }
        return bStringBuilder.toString();
    }
}
// @lc code=end

