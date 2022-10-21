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
// Related Topics 哈希表 字符串 回溯 👍 1860 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, List<String>> map = new HashMap<>(8);
        List<String> res = new ArrayList<>();
        String path = "";
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return res;

            map.put('2', Arrays.asList("a", "b", "c"));
            map.put('3', Arrays.asList("d", "e", "f"));
            map.put('4', Arrays.asList("g", "h", "i"));
            map.put('5', Arrays.asList("j", "k", "l"));
            map.put('6', Arrays.asList("m", "n", "o"));
            map.put('7', Arrays.asList("p", "p", "r", "s"));
            map.put('8', Arrays.asList("t", "u", "v"));
            map.put('9', Arrays.asList("w", "x", "y", "z"));

            int n = digits.length();

            backtracking(n, digits, 0);

            return res;

        }

        public void backtracking(int n, String digits, int beginIdex) {
            if (n == path.length()) {
                res.add(path);
                return;
            }

            for (int i = 0; i < map.get(digits.charAt(beginIdex)).size(); i++) {
                path = path + map.get(digits.charAt(beginIdex)).get(i);
                backtracking(n, digits, beginIdex + 1);
                path = path.substring(0, path.length() - 1);

            }

        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
