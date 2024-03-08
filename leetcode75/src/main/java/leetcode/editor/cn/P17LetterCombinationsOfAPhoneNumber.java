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
// Related Topics 哈希表 字符串 回溯 👍 2768 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：17. 电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] words = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return res;
            }

            backtracking(digits, 0);

            return res;
        }

        public void backtracking(String digits, int index) {
            if (path.length() == digits.length()) {
                res.add(path.toString());
                return;
            }

            char d = digits.charAt(index);

            for (char w : words[d - '2']) {
                path.append(w);
                backtracking(digits, index + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
