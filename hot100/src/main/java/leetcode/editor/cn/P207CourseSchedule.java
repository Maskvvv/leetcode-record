package leetcode.editor.cn;
//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。
//
//
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
//
// 示例 2：
//
//
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
//
//
//
// 提示：
//
//
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// prerequisites[i] 中的所有课程对 互不相同
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1810 👎 0

import leetcode.editor.cn.utils.GridUtils;

import java.util.ArrayList;
import java.util.List;

//Java：207. 课程表
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        // TO TEST
        System.out.println(solution.canFinish(7, GridUtils.generateIntGrid("[[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }

            for (int i = 0; i < prerequisites.length; i++) {
                adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            int[] visited = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0) {
                    if (!dfs(visited, i, adjacency)) return false;
                }
            }
            return true;
        }

        public boolean dfs(int[] visited, int i, List<List<Integer>> adjacency) {
            if (visited[i] == -1) return true;
            if (visited[i] == 1) return false;

            visited[i] = 1;

            List<Integer> courses = adjacency.get(i);
            for (Integer cours : courses) {
                if (!dfs(visited, cours, adjacency)) return false;
            }

            visited[i] = -1;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
