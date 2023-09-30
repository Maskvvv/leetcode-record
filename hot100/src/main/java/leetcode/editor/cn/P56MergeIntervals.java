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
// Related Topics 数组 排序 👍 2114 👎 0

import leetcode.editor.cn.utils.GridUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

//Java：56. 合并区间
public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
        System.out.println(Arrays.deepToString(solution.merge(GridUtils.generateGrid("[[1,3],[2,6],[8,10],[15,18]]"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

            Deque<int[]> list = new ArrayDeque<>();
            list.addLast(intervals[0]);

            for (int i = 1; i < intervals.length; i++) {
                int[] last = list.peekLast();
                if (last[1] >= intervals[i][0]) {
                    last[1] = Math.max(last[1], intervals[i][1]);
                } else {
                    list.addLast(intervals[i]);
                }
            }

            int[][] res = new int[list.size()][];

            int size = list.size();
            for (int i = 0; i < size; i++) {
                res[i] = list.pollFirst();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
