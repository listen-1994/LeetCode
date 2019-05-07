/**
 * LeetCode 第73题 矩阵置零
 * 常数级空间复杂度的算法没想出来
 */
public class Problem73 {

    /**
     * 空间复杂度（m+n）
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] column = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (column[j] == 1) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        Problem73 problem73 = new Problem73();
        int[][] matrix = new int[][]{{1,2,1},{1,1,4},{1,2,5},{9,0,1}};
        problem73.setZeroes(matrix);
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}