package HashTable;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 第36题
 * 有效的数独
 * 哈希表
 */
public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> map = new HashSet<Character>();
        for (int i = 0; i < board.length; i++) {
            map.clear();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (map.contains(board[i][j])) {
                        return false;
                    } else {
                        map.add(board[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            map.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (map.contains(board[j][i])) {
                        return false;
                    } else {
                        map.add(board[j][i]);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                map.clear();
                for (int k = 0; k < 3; k++) {
                    if (board[i + k][j] != '.') {
                        if (map.contains(board[i + k][j])) {
                            return false;
                        } else {
                            map.add(board[i + k][j]);
                        }
                    }
                    if (board[i + k][j + 1] != '.') {
                        if (map.contains(board[i + k][j + 1])) {
                            return false;
                        } else {
                            map.add(board[i + k][j + 1]);
                        }
                    }
                    if (board[i + k][j + 2] != '.') {
                        if (map.contains(board[i + k][j + 2])) {
                            return false;
                        } else {
                            map.add(board[i + k][j + 2]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
