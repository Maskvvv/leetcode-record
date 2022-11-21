package leetcode.editor.cn;
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti <= endi <= 10⁴
//
//
// Related Topics 数组 排序 👍 1712 👎 0


import java.util.Arrays;
import java.util.Comparator;

//Java：合并区间
public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
        int[][] ints = {{1,3},{15,18},{2,6},{8,10}};

        System.out.println(Arrays.deepToString(solution.merge(ints)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

            int index = 0;

            for (int i = 1; i < intervals.length; i++) {
                int[] pre = intervals[index];
                int[] current = intervals[i];

                if (current[0] <= pre[1]) {
                    if (current[1] > pre[1]) {
                        pre[1] = current[1];
                    }

                } else {
                    index++;

                    intervals[index][0] = current[0];
                    intervals[index][1] = current[1];
                }
            }
            return Arrays.copyOf(intervals, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
