package leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
//
// Related Topics 哈希表 字符串 回溯 👍 2163 👎 0


import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        int n = 0;

        public List<String> letterCombinations(String digits) {
            n = digits.length();
            if (n < 1) return res;

            String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            backtracking(numString, digits, 0);
            return res;
        }

        public void backtracking(String[] numString, String digits, int current) {
            if (path.length() == n) {
                res.add(path.toString());
                return;
            }

            String num = numString[digits.charAt(current) - '0'];

            for (int i = 0; i < num.length(); i++) {
                path.append(num.charAt(i));
                backtracking(numString, digits, current + 1);
                path.deleteCharAt(path.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
