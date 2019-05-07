import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第54题 螺旋矩阵
 * 数组
 */
public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        if(matrix.length==0){
            return result;
        }
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        while (x2 >= x1 && y2 >= y1) {
            result.addAll(oneVisit(matrix, x1, y1, x2, y2));
            x1 = x1 + 1;
            y1 = y1 + 1;
            x2 = x2 - 1;
            y2 = y2 - 1;
        }
        return result;
    }

    public List<Integer> oneVisit(int[][] matrix, int x1, int y1, int x2, int y2) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = y1; i <= y2; i++) {
            result.add(matrix[x1][i]);
        }
        for (int i = x1 + 1; i <= x2; i++) {
            result.add(matrix[i][y2]);
        }
        if(x2!=x1){
            for (int i = y2 - 1; i >= y1; i--) {
                result.add(matrix[x2][i]);
            }
        }
        if(y2!=y1){
            for (int i = x2 - 1; i >= x1 + 1; i--) {
                result.add(matrix[i][y1]);
            }
        }
        return result;
    }
}
