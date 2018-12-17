package DynamicProgramming;

/**
 * LeetCode 第62题
 * 不同路径
 */
public class UniquePaths {
    int[][] sav;
    public int uniquePaths(int m,int n){
        sav=new int[m][n];
        for(int i=0;i<m;i++){
            sav[i][0]=1;
        }
        for(int i=0;i<n;i++){
            sav[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                sav[i][j]=sav[i-1][j]+sav[i][j-1];
            }
        }
        return sav[m-1][n-1];
    }

    public static void main(String[] args){
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,2));
    }
}
