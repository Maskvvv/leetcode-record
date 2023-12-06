package leetcode.editor.cn;
//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
//
// 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
//
//
//
// 示例 1：
//
//
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
//注意：x 是未定义的 => -1.0
//
// 示例 2：
//
//
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
//
//
// 示例 3：
//
//
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
//
//
//
//
// 提示：
//
//
// 1 <= equations.length <= 20
// equations[i].length == 2
// 1 <= Ai.length, Bi.length <= 5
// values.length == equations.length
// 0.0 < values[i] <= 20.0
// 1 <= queries.length <= 20
// queries[i].length == 2
// 1 <= Cj.length, Dj.length <= 5
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 最短路 👍 1048 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：399. 除法求值
public class P399EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new P399EvaluateDivision().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int equationSize = equations.size();
            UnionFind unionFind = new UnionFind(2 * equationSize);
            Map<String, Integer> indexMap = new HashMap<>(2 * equationSize);
            int index = 0;

            for (int i = 0; i < equationSize; i++) {
                List<String> equation = equations.get(i);
                String s1 = equation.get(0);
                String s2 = equation.get(1);

                if (!indexMap.containsKey(s1)) {
                    indexMap.put(s1, index++);
                }

                if (!indexMap.containsKey(s2)) {
                    indexMap.put(s2, index++);
                }

                unionFind.union(indexMap.get(s1), indexMap.get(s2), values[i]);
            }


            int queriesSize = queries.size();
            double[] res = new double[queriesSize];

            for (int i = 0; i < queriesSize; i++) {
                List<String> querie = queries.get(i);
                String s1 = querie.get(0);
                String s2 = querie.get(1);

                if (!indexMap.containsKey(s1) || !indexMap.containsKey(s2)) {
                    res[i] = -1.0d;
                } else {
                    res[i] = unionFind.isConnected(indexMap.get(s1), indexMap.get(s2));
                }
            }

            return res;

        }


        class UnionFind {

            int[] parent;
            double[] weight;

            public UnionFind(int size) {
                parent = new int[size];
                weight = new double[size];

                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    weight[i] = 1.0d;
                }
            }

            public void union(int x, int y, double value) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX == rootY) {
                    return;
                }

                parent[rootX] = rootY;

                weight[rootX] = value * weight[y] / weight[x];
            }

            public int find(int x) {
                if (x != parent[x]) {
                    int original = parent[x];
                    parent[x] = find(parent[x]);
                    weight[x] *= weight[original];
                }
                return parent[x];
            }

            public double isConnected(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX == rootY) {
                    return weight[x] / weight[y];
                } else {
                    return -1.0d;
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
