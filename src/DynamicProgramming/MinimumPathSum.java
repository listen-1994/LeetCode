package DynamicProgramming;

/**
 * LeetCode 第64题
 * 最小路径和
 */
public class MinimumPathSum {
    int[][] sav ;
    public int minPathSum(int[][] grid){
        sav=new int[grid.length][grid[0].length];
        sav[0][0]=grid[0][0];
        for(int i=1;i<grid.length;i++){
            sav[i][0]=sav[i-1][0]+grid[i][0];
        }
        for(int i=1;i<grid[0].length;i++){
            sav[0][i]=sav[0][i-1]+grid[0][i];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                sav[i][j]=Math.min(sav[i-1][j],sav[i][j-1])+grid[i][j];
            }
        }
        return sav[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args){
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
