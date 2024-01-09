package leetcode.editor.cn;
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= ransomNote.length, magazine.length <= 10⁵
// ransomNote 和 magazine 由小写英文字母组成
//
//
// Related Topics 哈希表 字符串 计数 👍 858 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：383. 赎金信
public class P383RansomNote {
    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> magzineMap = new HashMap<>();

            for (char c : magazine.toCharArray()) {
                Integer count = magzineMap.getOrDefault(c, 0);
                magzineMap.put(c, count + 1);
            }

            for (char c : ransomNote.toCharArray()) {
                Integer count = magzineMap.getOrDefault(c, 0);
                if (count == 0) return false;

                magzineMap.put(c, count - 1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
