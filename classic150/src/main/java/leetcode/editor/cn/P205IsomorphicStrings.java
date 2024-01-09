package leetcode.editor.cn;
//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
// 示例 1:
//
//
//输入：s = "egg", t = "add"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "foo", t = "bar"
//输出：false
//
// 示例 3：
//
//
//输入：s = "paper", t = "title"
//输出：true
//
//
//
// 提示：
//
//
//
//
//
// 1 <= s.length <= 5 * 10⁴
// t.length == s.length
// s 和 t 由任意有效的 ASCII 字符组成
//
//
// Related Topics 哈希表 字符串 👍 686 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：205. 同构字符串
public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {

            Map<Character, Character> s2t = new HashMap<>();
            Map<Character, Character> t2s = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char k1 = s.charAt(i);
                char k2 = t.charAt(i);


                if (s2t.containsKey(k1) && s2t.get(k1) != k2
                        || t2s.containsKey(k2) && t2s.get(k2) != k1) {
                    return false;
                }

                s2t.put(k1, k2);
                t2s.put(k2, k1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
