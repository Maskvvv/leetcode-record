package leetcode.editor.cn;
//有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中
//edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
//
// 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
//
// 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回
//true，否则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
//输出：true
//解释：存在由顶点 0 到顶点 2 的路径:
//- 0 → 1 → 2
//- 0 → 2
//
//
// 示例 2：
//
//
//输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
//
//输出：false
//解释：不存在由顶点 0 到顶点 5 的路径.
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2 * 10⁵
// 0 <= edges.length <= 2 * 10⁵
// edges[i].length == 2
// 0 <= ui, vi <= n - 1
// ui != vi
// 0 <= source, destination <= n - 1
// 不存在重复边
// 不存在指向顶点自身的边
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 162 👎 0

//Java：1971. 寻找图中是否存在路径
public class P1971FindIfPathExistsInGraph {
    public static void main(String[] args) {
        Solution solution = new P1971FindIfPathExistsInGraph().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] father;
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            father = new int[n];
            init();
            for (int i = 0; i < edges.length; i++) {
                join(edges[i][0], edges[i][1]);
            }

            return isSame(source, destination);
        }

        // 并查集初始化
        public void init() {
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
        }

        // 并查集里寻根的过程
        public int find(int u) {
            if (u == father[u]) {
                return u;
            } else {
                father[u] = find(father[u]);
                return father[u];
            }
        }

        // 判断 u 和 v是否找到同一个根
        public boolean isSame(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }

        // 将v->u 这条边加入并查集
        public void join(int u, int v) {
            u = find(u); // 寻找u的根
            v = find(v); // 寻找v的根
            if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回

            father[v] = u;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
