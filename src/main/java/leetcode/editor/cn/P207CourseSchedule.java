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
// 1 <= numCourses <= 10⁵
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// prerequisites[i] 中的所有课程对 互不相同
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1254 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：课程表
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // 构建邻接表由数组和链表构成：1. 数组：numCourses 门课程 2. 链表：该课程是哪几门课程的前置条件
            List<List<Integer>> adjacency = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new LinkedList<>());
            }

            for (int[] prerequisite : prerequisites) {
                adjacency.get(prerequisite[1]).add(prerequisite[0]);
            }

            // flag[i]：
            // -1. 该节点是一个有向无环图路径的一个节点 直接返回 true
            // 0. 该课程未被访问过 递归该节点
            // 1. 该课程已经被访问过了 说明遇到环了，返回false
            int[] flag = new int[numCourses];

            // 遍历递归每门课程
            for (int i = 0; i < numCourses; i++) {
                if (flag[i] == 0 && !dfs(adjacency, flag, i)) return false;
            }
            return true;
        }

        public boolean dfs(List<List<Integer>> adjacency, int[] flag, int i) {
            if (flag[i] == -1) return true;
            if (flag[i] == 1) return false;

            // 标记该节点在此次递归中被访问过了，来判断是否遇到了环
            flag[i] = 1;

            // 递归判断以该课程为前置条件的课程是否为环
            for (Integer next : adjacency.get(i)) {
                if (!dfs(adjacency, flag, next)) return false;
            }

            // 说明当前没有遇到环
            flag[i] = -1;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
