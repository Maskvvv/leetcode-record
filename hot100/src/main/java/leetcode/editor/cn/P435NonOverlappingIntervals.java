package leetcode.editor.cn;
//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。
//
//
//
// 示例 1:
//
//
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
//
//
//
// 提示:
//
//
// 1 <= intervals.length <= 10⁵
// intervals[i].length == 2
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴
//
//
// Related Topics 贪心 数组 动态规划 排序 👍 1050 👎 0

import java.util.Arrays;
import java.util.Comparator;

//Java：435. 无重叠区间
public class P435NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new P435NonOverlappingIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

            int count = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < intervals[i - 1][1]) {
                    count++;
                    intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












