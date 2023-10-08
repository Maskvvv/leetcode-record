package leetcode.editor.cn;
//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例 1：
//
//
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
//
//
// 示例 2：
//
//
//输入：s = "abcd", k = 2
//输出："bacd"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由小写英文组成
// 1 <= k <= 10⁴
//
//
// Related Topics 双指针 字符串 👍 536 👎 0

//Java：541. 反转字符串 II
public class P541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
        // TO TEST
        System.out.println(solution.reverseStr("abcd", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] array = s.toCharArray();

            for (int i = 0; i < array.length; i = i + 2 * k) {
                int left = i, right = Math.min(array.length - 1, i + k - 1);

                swap(array, left, right);
            }

            return new String(array);
        }

        public void swap(char[] array, int left, int right) {
            int n = array.length;
            if (n < 2) return;

            while (left < right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
