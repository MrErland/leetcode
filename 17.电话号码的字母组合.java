import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.32%)
 * Likes:    527
 * Dislikes: 0
 * Total Accepted:    65.9K
 * Total Submissions: 127.3K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
    public char[] getChar(int i) {
        if (2 <= i && i <= 6) {
            char first = (char)('a' + (i - 2) * 3);
            return new char[]{first, (char)(first + 1), (char)(first + 2)};
        }else if (i == 7) {
            return new char[]{'p', 'q', 'r', 's'};
        }else if (i == 8) {
            return new char[]{'t', 'u', 'v'};
        }else if (i == 9) {
            return new char[]{'w', 'x', 'y', 'z'};
        }
        return null;
    }

    void dfs(String str, ArrayList<char[]> nums, int i, List<String> ans) {
        if (i == nums.size()) {
            ans.add(str.toString());
            return;
        }
        for (char c : nums.get(i)) {
            str += c;
            dfs(str, nums, i + 1, ans);
            str = str.substring(0, str.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        ArrayList<char[]> nums = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            char [] num = getChar(Integer.parseInt(digits.substring(i, i + 1)));
            nums.add(num);
        }

        List<String> ans = new ArrayList<String>();
        if (n > 0) {
            for (char c : nums.get(0)) {
                String str = "";
                str += c;
                dfs(str, nums, 1, ans);
            }
        }
        return ans;
    }
}
// @lc code=end

