package DynamicProgramming;

/**
 * LeetCode 第221题
 * 最大正方形
 */
public class MaximalSquare {

    /**
     * 只击败了0.93%的用户
     * 这题其实和最大矩形有点类似，应该用相应方法计算
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int result=0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
                result=1;
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]=='1'){
                dp[0][i]=1;
                result=1;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    continue;
                }
                if(dp[i-1][j-1]==0){
                    if(matrix[i][j]=='1'){
                        dp[i][j]=1;
                        if(result<1){
                            result=1;
                        }
                    }
                    continue;
                }
                int length = dp[i-1][j-1];
                int flag = 0;
                for(int k=1;k<=length;k++){
                    if(matrix[i-k][j]!='1'||matrix[i][j-k]!='1'){
                        break;
                    }else{
                        flag++;
                    }
                }
                dp[i][j]=1+flag;
                if(dp[i][j]>result){
                    result = dp[i][j];
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.println(i+"|"+j+":"+dp[i][j]);
            }
        }
        return result*result;
    }

    public static void main(String[] args){
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}}));
    }
}
