package leetcode.editor.cn;
//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
//
//
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
//
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
//
//
//
// 示例 1：
//
//
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
//
//
// 示例 2：
//
//
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
//
// 示例 3：
//
//
//输入：numCourses = 1, prerequisites = []
//输出：[0]
//
//
//
//提示：
//
//
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= numCourses * (numCourses - 1)
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// ai != bi
// 所有[ai, bi] 互不相同
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 905 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：210. 课程表 II
public class P210CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new P210CourseScheduleIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            Map<Integer, List<Integer>> adjacency = new HashMap<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                adjacency.put(i, new ArrayList<>());
            }

            int[] inDegree = new int[numCourses];

            for (int[] prerequisite : prerequisites) {
                int course0 = prerequisite[0];
                int course1 = prerequisite[1];

                adjacency.get(course1).add(course0);
                inDegree[course0]++;
            }

            int[] res = new int[numCourses];
            int index = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);

                }
            }

            while (!queue.isEmpty()) {
                Integer top = queue.poll();
                res[index++] = top;
                for (Integer i : adjacency.get(top)) {
                    inDegree[i]--;

                    if (inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }

            if (index != numCourses) return new int[0];

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
