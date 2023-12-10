package leetcode.editor.cn;
//给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n² 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1
//][0] 开始）每一行交替方向。
//
// 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
//
// 每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
//
//
// 选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n²)] 。
//
//
//
// 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
//
//
// 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
// 当玩家到达编号 n² 的方格时，游戏结束。
//
//
// r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是
//board[r][c]。编号为 1 和 n² 的方格上没有蛇或梯子。
//
// 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
//
//
// 举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3
// 上的梯子前往方格 4 。
//
//
// 返回达到编号为 n² 的方格所需的最少移动次数，如果不可能，则返回 -1。
//
//
//
// 示例 1：
//
//
//输入：board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35
//,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
//输出：4
//解释：
//首先，从方格 1 [第 5 行，第 0 列] 开始。
//先决定移动到方格 2 ，并必须爬过梯子移动到到方格 15 。
//然后决定移动到方格 17 [第 3 行，第 4 列]，必须爬过蛇到方格 13 。
//接着决定移动到方格 14 ，且必须通过梯子移动到方格 35 。
//最后决定移动到方格 36 , 游戏结束。
//可以证明需要至少 4 次移动才能到达最后一个方格，所以答案是 4 。
//
//
// 示例 2：
//
//
//输入：board = [[-1,-1],[-1,3]]
//输出：1
//
//
//
//
// 提示：
//
//
// n == board.length == board[i].length
// 2 <= n <= 20
// grid[i][j] 的值是 -1 或在范围 [1, n²] 内
// 编号为 1 和 n² 的方格上没有蛇或梯子
//
//
// Related Topics 广度优先搜索 数组 矩阵 👍 126 👎 0

import leetcode.editor.cn.utils.GridUtils;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：909. 蛇梯棋
public class P909SnakesAndLadders {
    public static void main(String[] args) {
        Solution solution = new P909SnakesAndLadders().new Solution();
        // TO TEST

        System.out.println(solution.snakesAndLadders(GridUtils.generateIntGrid("[[-1,-1,19,10,-1],[2,-1,-1,6,-1],[-1,17,-1,19,-1],[25,-1,20,-1,-1],[-1,-1,-1,-1,15]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            boolean[] visited = new boolean[n * n + 1];

            visited[1] = true;
            Deque<int[]> queue = new ArrayDeque<>();
            queue.addLast(new int[]{1, 0});

            while (!queue.isEmpty()) {
                int[] q = queue.removeFirst();

                int curIndex = q[0];
                int curStep = q[1];

                if (curIndex == n * n) return curStep;

                for (int i = 1; i <= 6; i++) {
                    int nextIndex = curIndex + i;
                    if (nextIndex > n * n) break;

                    int[] rc = id2rc(nextIndex, n);
                    int r = rc[0];
                    int c = rc[1];

                    nextIndex = board[r][c] == -1 ? nextIndex : board[r][c];
                    if (!visited[nextIndex]) {
                        visited[nextIndex] = true;
                        queue.addLast(new int[]{nextIndex, curStep + 1});

                    }
                }
            }

            return -1;
        }

        public int[] id2rc(int id, int n) {
            int r = (id - 1) / n, c = (id - 1) % n;
            if (r % 2 == 1) {
                c = n - 1 - c;
            }
            return new int[]{n - 1 - r, c};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
