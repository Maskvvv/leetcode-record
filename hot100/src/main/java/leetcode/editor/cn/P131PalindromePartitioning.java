package leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
//
// Related Topics 字符串 动态规划 回溯 👍 1620 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：131. 分割回文串
public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
        System.out.println(solution.partition("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        public List<List<String>> partition(String s) {
            backtracking(s, 0);

            return res;
        }

        public void backtracking(String s, int startIndex) {
            if (startIndex >= s.length()) {
                res.add(new ArrayList<>(path));
            }

            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindrome(s, startIndex, i)) {
                    path.addLast(s.substring(startIndex, i + 1));
                } else {
                    continue;
                }

                backtracking(s, i + 1);
                path.removeLast();
            }

        }

        private boolean isPalindrome(String s, int startIndex, int i) {

            while (startIndex < i) {
                if (s.charAt(startIndex) != s.charAt(i)) return false;

                startIndex++;
                i--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
