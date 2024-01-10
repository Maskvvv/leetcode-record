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
// Related Topics 哈希表 字符串 排序 👍 886 👎 0

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

            int[] m1 = new int[26];
            int[] m2 = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                m1[c1 - 'a']++;

               char c2 = t.charAt(i);
                m2[c2 - 'a']++;
            }

            for (int i = 0; i < m1.length; i++) {
                if (m1[i] != m2[i]) return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
