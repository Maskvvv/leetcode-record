package leetcode.editor.cn;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//
//
// 示例 1:
//
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
//
//输入: s = "rat", t = "car"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= s.length, t.length <= 5 * 10⁴
// s 和 t 仅包含小写字母
//
//
//
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
//
// Related Topics 哈希表 字符串 排序 👍 853 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：242. 有效的字母异位词
public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST

        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (char c : s.toCharArray()) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }

            for (char c : t.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }

            if (map1.size() != map2.size()) return false;

            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {

                Character key = entry.getKey();
                if (map2.get(key) == null || !entry.getValue().equals(map2.get(key))) return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
