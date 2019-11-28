import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.32%)
 * Likes:    1550
 * Dislikes: 0
 * Total Accepted:    121.4K
 * Total Submissions: 495.4K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution 
{
    public int binary(int[] nums, int i, int j, int x)
    {
        if (j - i <= 1)
        {
            if (nums[i] + x == 0)
            {
                return i;
            }
            if (nums[j] + x == 0)
            {
                return j;
            }
            return -1;
        }
        int k = (i + j) / 2;
        if (nums[k] + x < 0)
        {
            return binary(nums, k, j, x);
        }
        else if (nums[k] + x > 0)
        {
            return binary(nums, i, k, x);
        }
        else
        {
            return k;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0)
        {
            return ans;
        }
        if (nums.length >= 3 && nums[0] == nums[nums.length - 1])
        {
            List<Integer> one = new ArrayList<>(3);
            one.add(0); one.add(0); one.add(0);
            ans.add(one);
            return ans;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0) 
            {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++)
            {
                if (nums[i] + nums[j] > 0)
                {
                    break;
                }
                int k = binary(nums, j + 1, nums.length - 1, nums[i] + nums[j]);
                if (k != -1)
                {
                    List<Integer> one = new ArrayList<>(3);
                    one.add(nums[i]);
                    one.add(nums[j]);
                    one.add(nums[k]);
                    if (!ans.contains(one))
                    {
                        ans.add(one);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

