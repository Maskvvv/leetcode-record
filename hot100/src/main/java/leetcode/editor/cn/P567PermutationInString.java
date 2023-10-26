package leetcode.editor.cn;
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。
//
//
//
// 示例 1：
//
//
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
//
//
// 示例 2：
//
//
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 10⁴
// s1 和 s2 仅包含小写字母
//
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 967 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：567. 字符串的排列
public class P567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST

        System.out.println(solution.checkInclusion("abcdxabcde", "abcdeabcdx"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            char[] chars1 = s1.toCharArray();
            for (char c : chars1) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int count = 0;

            char[] chars2 = s2.toCharArray();
            while (right < s2.length()) {
                char c = chars2[right];
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        count++;
                    }
                }

                while (right - left >= s1.length()) {
                    if (count == need.size()) return true;
                    char c1 = chars2[left];
                    left++;
                    if (need.containsKey(c1)) {
                        if (window.get(c1).equals(need.get(c1))) {
                            count--;
                        }
                        window.put(c1, window.get(c1) - 1);
                    }
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
