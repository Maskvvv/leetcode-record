package leetcode.editor.cn;
//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
// 示例 1：
//
//
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
// 示例 2：
//
//
//输入：triangle = [[-10]]
//输出：-10
//
//
//
//
// 提示：
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -10⁴ <= triangle[i][j] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
//
// Related Topics 数组 动态规划 👍 992 👎 0


import java.util.List;

//Java：三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            if (n == 1) return triangle.get(0).get(0);

            for (int i = 1; i < n; i++) {
                List<Integer> sub = triangle.get(i);
                int size = sub.size() - 1;
                sub.set(0, triangle.get(i - 1).get(0));
                sub.set(size, triangle.get(i - 1).get(size - 1));

            }

            int res = Math.min(triangle.get(n - 1).get(0), triangle.get(n - 1).get(triangle.get(n - 1).size() - 1));
            for (int i = 3; i < n; i++) {
                List<Integer> sub = triangle.get(i);
                int subSize = sub.size() - 1;
                for (int j = 1; j < subSize; j++) {

                    sub.set(j, sub.get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j + 1)));

                    res = (i == triangle.size() - 1 && sub.get(j) < res) ? sub.get(j) : res;
                }

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
