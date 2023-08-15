package leetcode.editor.cn;
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
//输入: numRows = 1
//输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics 数组 动态规划 👍 1042 👎 0


import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        // TO TEST

        solution.generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> dp = new ArrayList<>(numRows);

            for (int i = 0; i < numRows; i++) {
                List<Integer> item = new ArrayList<>(i + 1);
                dp.add(item);
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j ==i) {
                        item.add(1);
                    } else {
                        item.add(dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
                    }
                }
            }

            return dp;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
