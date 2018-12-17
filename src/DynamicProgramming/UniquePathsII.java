package DynamicProgramming;

/**
 * LeetCode 第63题
 * 不同路径II
 */
public class UniquePathsII {
    int sav[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        sav=new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i=0;i<sav.length;i++){
            if(obstacleGrid[i][0]==1){
                sav[i][0]=0;
            }else{
                if(i==0){
                    sav[i][0]=1;
                }else{
                    sav[i][0]=sav[i-1][0];
                }
            }
        }
        for(int i=1;i<sav[0].length;i++){
            if(obstacleGrid[0][i]==1){
                sav[0][i]=0;
            }else{
                sav[0][i]=sav[0][i-1];
            }
        }
        for(int i=1;i<sav.length;i++){
            for(int j=1;j<sav[i].length;j++){
                if(obstacleGrid[i][j]==1){
                    sav[i][j]=0;
                }else{
                    sav[i][j]=sav[i-1][j]+sav[i][j-1];
                }
            }
        }
        return sav[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args){
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

}
