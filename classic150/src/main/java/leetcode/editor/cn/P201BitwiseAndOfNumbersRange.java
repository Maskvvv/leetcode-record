package leetcode.editor.cn;
//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。
//
//
//
// 示例 1：
//
//
//输入：left = 5, right = 7
//输出：4
//
//
// 示例 2：
//
//
//输入：left = 0, right = 0
//输出：0
//
//
// 示例 3：
//
//
//输入：left = 1, right = 2147483647
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= left <= right <= 2³¹ - 1
//
//
// Related Topics 位运算 👍 485 👎 0

//Java：201. 数字范围按位与
public class P201BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new P201BitwiseAndOfNumbersRange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int shift = 0;

            while (left < right) {
                left >>= 1;
                right >>= 1;
                shift++;
            }

            return left << shift;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
