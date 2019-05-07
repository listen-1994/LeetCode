import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 第51题 N皇后
 * 困难
 * 回溯算法
 */

public class Problem51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int[][] chessboart = new int[n][n];
        core(chessboart, 0, n, result);
        return result;
    }

    public void core(int[][] chessboard, int index, int n, List<List<String>> result) {
        for (int i = 0; i < n; i++) {
            if (chessboard[index][i] == 0) {
                //java 一维数组是深克隆，二维数组是浅克隆!!
                int[][] boardClone = clone(chessboard);
                boardClone[index][i] = 1;
                set(boardClone, index, i, n);
                /*System.out.println(index + "-" + i);
                printChessboard(chessboard, "chessboard");
                printChessboard(boardClone, "boardClone");*/
                if (index == n - 1) {
                    addResult(boardClone, result, n);
                } else {
                    core(boardClone, index + 1, n, result);
                }
            }
        }
    }

    public void set(int[][] chessboard, int x, int y, int n) {
        for (int i = x + 1; i < n; i++) {
            chessboard[i][y] = 2;
        }
        int i = x + 1;
        int j = y - 1;
        while (i < n && j >= 0) {
            chessboard[i][j] = 2;
            i++;
            j--;
        }
        i = x + 1;
        j = y + 1;
        while (i < n && j < n) {
            chessboard[i][j] = 2;
            i++;
            j++;
        }
    }

    public void addResult(int[][] chessboard, List<List<String>> result, int n) {
        LinkedList<String> subReslt = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                if (chessboard[i][j] == 1) {
                    line += "Q";
                } else {
                    line += ".";
                }
            }
            subReslt.add(line);
        }
        result.add(subReslt);
    }

    public int[][] clone(int[][] chessboard) {
        int[][] boardClone = new int[chessboard.length][chessboard[0].length];
        for (int i = 0; i < chessboard.length; i++) {
            boardClone[i] = chessboard[i].clone();
        }
        return boardClone;
    }

    public void printChessboard(int[][] chessboard, String str) {
        System.out.println("<------------" + str + "--------->");
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                System.out.print(chessboard[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Problem51 problem51 = new Problem51();
        System.out.println(problem51.solveNQueens(4));
    }
}
