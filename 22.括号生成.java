import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    public boolean isValidStr(Stack<Character>stack, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void backendMethod(List<String> ans, String str, int x, int n) {
        Stack<Character> stack = new Stack<Character>();
        if (!isValidStr(stack, str) || x > 2 * n) {
            return;
        }
        if (stack.isEmpty() && x == 2 * n) {
            ans.add(str);
            return;
        }
        backendMethod(ans, str + "(", x + 1, n);
        backendMethod(ans, str + ")", x + 1, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n <= 0) {
            return ans;
        }
        backendMethod(ans, "", 0, n);
        return ans;
    }
}
// @lc code=end

