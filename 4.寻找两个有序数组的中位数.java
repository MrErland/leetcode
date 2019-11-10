/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.99%)
 * Likes:    1576
 * Dislikes: 0
 * Total Accepted:    95.8K
 * Total Submissions: 266.2K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution 
{
    // 时间复杂度 O(m + n)，还有优化的空间
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int n = nums1.length + nums2.length;
        int [] sum = new int[n];
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length)
        {
            if (nums1[i] > nums2[j])
            {
                sum[i + j] = nums2[j];
                j++;
            }
            else
            {
                sum[i + j] = nums1[i];
                i++;
            }
        }
        while (i < nums1.length)
        {
            sum[i + j] = nums1[i];
            i++;
        }
        while (j < nums2.length)
        {
            sum[i + j] = nums2[j];
            j++;
        }
        if (n % 2 == 0)
        {
            return (sum[n / 2] + sum[n / 2 - 1]) / 2.0;
        }
        else
        {
            return sum[n / 2] * 1.0;
        }
    }
}

