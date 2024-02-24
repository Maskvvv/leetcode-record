package leetcode.editor.cn;
//n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输
//部决定重新规划路线，以改变交通拥堵的状况。
//
// 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
//
// 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
//
// 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
//
// 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
//
//
//
// 示例 1：
//
//
//
// 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//输出：3
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
// 示例 2：
//
//
//
// 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//输出：2
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
// 示例 3：
//
// 输入：n = 3, connections = [[1,0],[2,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// 2 <= n <= 5 * 10^4
// connections.length == n-1
// connections[i].length == 2
// 0 <= connections[i][0], connections[i][1] <= n-1
// connections[i][0] != connections[i][1]
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 219 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：1466. 重新规划路线
public class P1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        Solution solution = new P1466ReorderRoutesToMakeAllPathsLeadToTheCityZero().new Solution();
        // TO TEST


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int count = 0;
        public int minReorder(int n, int[][] connections) {
            List<List<Integer>> graph = buildGraph(n, connections);

            boolean[] visited = new boolean[n];
            dfs(0, graph, visited);

            return count;
        }

        public void dfs(int city, List<List<Integer>> graph, boolean[] visited) {
            visited[city] = true;
            for (int to : graph.get(city)) {
                if (!visited[Math.abs(to)]) {
                    if (to > 0) {
                        count++;
                    }

                    dfs(Math.abs(to), graph, visited);
                }
            }
        }



        private void dfs(List<List<Integer>> graph, boolean[] visited, int city) {
            visited[city] = true;
            for (int neighbor : graph.get(city)) {
                if (!visited[Math.abs(neighbor)]) {
                    if (neighbor > 0) {
                        count++;
                    }
                    dfs(graph, visited, Math.abs(neighbor));
                }
            }
        }


        public List<List<Integer>> buildGraph(int n, int[][] connections) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] connection : connections) {
                int from = connection[0];
                int to = connection[1];

                graph.get(from).add(to);
                graph.get(to).add(-from);
            }

            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
