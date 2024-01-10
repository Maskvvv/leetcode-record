package leetcode.editor.cn;
//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
//
//
//
// 示例1:
//
//
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true
//
// 示例 2:
//
//
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false
//
// 示例 3:
//
//
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= pattern.length <= 300
// pattern 只包含小写英文字母
// 1 <= s.length <= 3000
// s 只包含小写英文字母和 ' '
// s 不包含 任何前导或尾随对空格
// s 中每个单词都被 单个空格 分隔
//
//
// Related Topics 哈希表 字符串 👍 628 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：290. 单词规律
public class P290WordPattern {
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            char[] a = pattern.toCharArray();
            String[] b = s.split(" ");
            if (a.length != b.length) return false;

            Map<Character, String> m1 = new HashMap<>();
            Map<String, Character> m2 = new HashMap<>();

            for (int i = 0; i < a.length; i++) {
                char c1 = a[i];
                String c2 = b[i];

                if (m1.containsKey(c1) && !m1.get(c1).equals(c2)
                || m2.containsKey(c2) && !m2.get(c2).equals(c1)) {
                    return false;
                }

                m1.put(c1, c2);
                m2.put(c2, c1);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
