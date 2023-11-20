package leetcode.editor.cn;
//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
//
//
//
// 示例 1：
//
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= points.length <= 300
// points[i].length == 2
// -10⁴ <= xi, yi <= 10⁴
// points 中的所有点 互不相同
//
//
// Related Topics 几何 数组 哈希表 数学 👍 519 👎 0

import leetcode.editor.cn.utils.GridUtils;

//Java：149. 直线上最多的点数
public class P149MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new P149MaxPointsOnALine().new Solution();
        // TO TEST
        System.out.println(solution.maxPoints(GridUtils.generateIntGrid("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {

            int n = points.length;

            int res = 0;
            for (int i = 0; i < n; i++) {
                int[] p1 = points[i];
                for (int j = i + 1; j < n; j++) {
                    int[] p2 = points[j];
                    int subRes = 2;
                    for (int k = j + 1; k < n; k++) {
                        int[] p3 = points[k];
                        int s1 = (p1[1] - p2[1]) * (p2[0] - p3[0]);
                        int s2 = (p2[1] - p3[1]) * (p1[0] - p2[0]);
                        if (s1 == s2) subRes++;
                    }

                    res = Math.max(res, subRes);
                }
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
