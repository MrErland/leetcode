/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;    
            }
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int head = j + 1;
                int tail = nums.length - 1;
                while (tail > head) {
                    int tmpSum = nums[i] + nums[j] + nums[head] + nums[tail];
                    if (tmpSum < target) {
                        head++;
                    } else if (tmpSum > target) {
                        tail--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
                        while (tail > head && nums[head] == nums[head + 1]) {
                            head++;
                        }
                        head++;
                        while (tail > head && nums[tail - 1] == nums[tail]) {
                            tail--;
                        }
                        tail--;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

