/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (33.17%)
 * Likes:    1426
 * Dislikes: 0
 * Total Accepted:    213.1K
 * Total Submissions: 642.7K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */

// @lc code=start
class Solution 
{
    public int reverse(int x) 
    {
        boolean munis = false;
        if (x < 0)
        {
            munis = true;
            x = Math.abs(x);
        }
        StringBuilder s = new StringBuilder(Integer.toString(x));
        s = s.reverse();
        for (int i = 0; i < s.length() - 1; i++)
        {
            if (s.charAt(i) == '0')
            {
                s.deleteCharAt(i);
                i -= 1;
            }
            else
            {
                break;
            }
        }
        try
        {
            int y = Integer.parseInt(s.toString());
            if (munis && y > Math.pow(2, 31))
            {
                return 0;
            }
            if (!munis && y > Math.pow(2, 31) - 1)
            {
                return 0;
            }
            return munis ? 0 - y : y;
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }
}
// @lc code=end

