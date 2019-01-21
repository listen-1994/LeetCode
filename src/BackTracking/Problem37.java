package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 第37题 解数独
 * 哈希表，回溯算法
 */
public class Problem37 {
    class Location {
        public int row;
        public int colum;

        public Location(int row, int colum) {
            this.row = row;
            this.colum = colum;
        }
    }

    public void solveSudoku(char[][] board) {
        int size = 9;
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '.') {
                    locations.add(new Location(i, j));
                }
            }
        }
        core(board, 0, locations);
    }

    public boolean core(char[][] board, int num, ArrayList<Location> locations) {
        if (num == locations.size()) {
            if (board[locations.get(num - 1).row][locations.get(num - 1).colum] == '.') {
                return false;
            } else {
                return true;
            }
        }
        Set<Character> notValid = isValid(board, locations.get(num).row, locations.get(num).colum);
        for (char i = '1'; i <= '9'; i++) {
            if (!notValid.contains(i)) {
                board[locations.get(num).row][locations.get(num).colum] = i;
                if (core(board, num + 1, locations)) {
                    return true;
                } else {
                    board[locations.get(num).row][locations.get(num).colum] = '.';
                }
            }
        }
        return false;
    }

    public Set<Character> isValid(char[][] board, int i, int j) {
        Set<Character> result = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            if (board[row][j] != '.') {
                result.add(board[row][j]);
            }
        }
        for (int column = 0; column < 9; column++) {
            if (board[i][column] != '.') {
                result.add(board[i][column]);
            }
        }

        int begin = i / 3;
        begin=begin*3;
        int end = j / 3;
        end=end*3;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (board[begin + m][end + n] != '.') {
                    result.add(board[begin + m][end + n]);
                }
            }
        }
        return result;
    }

    public void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("<--------------------------->");
    }

    public static void main(String[] args) {
        Problem37 problem37 = new Problem37();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        problem37.solveSudoku(board);
    }
}
