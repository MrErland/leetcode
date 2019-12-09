/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.95%)
 * Likes:    304
 * Dislikes: 0
 * Total Accepted:    59K
 * Total Submissions: 139.9K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution
{
    public int binary(int[] nums, int i, int j, int x)
    {
        int mid = (i + j) / 2;
        if (j - i < 2)
        {
            return Math.abs(nums[i] - x) < Math.abs(nums[j] - x) ? i : j;
        }
        if (nums[mid] > x)
        {
            return binary(nums, i, mid, x);
        }
        else if (nums[mid] < x)
        {
            return binary(nums, mid, j, x);
        }
        return mid;
    }

    public int threeSumClosest(int[] nums, int target) 
    {   
        int ans = target - Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = -1; i < nums.length - 1; i++)
        {
            for(int j = nums.length; j > i + 3; j--)
            {
                int x = binary(nums, i + 2, j - 2, target - nums[i + 1] - nums[j - 1]);
                if (x != -1 && Math.abs(target - nums[i + 1] - nums[j - 1] - nums[x]) 
                        < Math.abs(target - ans))
                {
                    ans = nums[i + 1] + nums[j - 1] + nums[x];
                }
            }
        }
        return ans;
    }
}
// @lc code=end

