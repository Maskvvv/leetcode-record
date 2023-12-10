package leetcode.editor.cn.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhongyin
 * @since 2022/11/22 15:14
 */
public class GraphFactory {

    public static List<List<String>> build(String graph) {
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        List<List<String>> res = new ArrayList<>();

        // "A","B","C","E"],["S","F","C","S"],["A","D","E","E"
        graph = graph.substring(2);

        graph = graph.replace("\"", "");

        List<String> subGraph = new ArrayList<>();

        for (int i = 0; i < graph.length(); i++) {
            char c = graph.charAt(i);

            if (c == ',') {
                continue;
            } else if (c == ']') {
                i += 2;
                res.add(subGraph);
                subGraph = new ArrayList<>();
                continue;
            } else {
                subGraph.add(String.valueOf(c));
            }
        }
        print(res);
        return res;
    }

    public static char[][] buildArray(String graph) {
        List<List<String>> graphList = build(graph);

        char[][] res = new char[graphList.size()][graphList.get(0).size()];

        for (int i = 0; i < graphList.size(); i++) {
            List<String> subGraph = graphList.get(i);
            for (int j = 0; j < subGraph.size(); j++) {
                res[i][j] = subGraph.get(j).charAt(0);
            }
        }

        return res;
    }

    public static int[][] buildIntArray(String graph) {
        List<List<String>> graphList = build(graph);

        int[][] res = new int[graphList.size()][graphList.get(0).size()];

        for (int i = 0; i < graphList.size(); i++) {
            List<String> subGraph = graphList.get(i);
            for (int j = 0; j < subGraph.size(); j++) {
                res[i][j] = subGraph.get(j).charAt(0);
            }
        }

        return res;
    }

    public static void print(String graph) {
        List<List<String>> graphList = build(graph);
        print(graphList);
    }

    public static <T> void print(List<List<T>> graphList) {

        for (List<T> graphs : graphList) {
            for (T s : graphs) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void print(char[][] graphArray) {
        for (char[] array : graphArray) {
            for (char c : array) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        String graph = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]";
        System.out.println(build(graph));

        //print(graph);

    }

}
