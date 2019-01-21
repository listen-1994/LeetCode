package DynamicProgramming;

import java.util.List;

/**
 * LeetCode 第120题
 * 三角形最小路径和
 */
public class Triangle {

    /**
     * 空间复杂度o(n^2)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] sav = new int[triangle.size()+1][triangle.size()+1];
        for(int i=1;i<=triangle.size();i++){
            for(int j=1;j<=triangle.get(i-1).size();j++){
                if(j==1){
                    sav[i][j]=sav[i-1][j]+triangle.get(i-1).get(j-1);
                }else if(j==triangle.get(i-1).size()){
                    sav[i][j]=sav[i-1][j-1]+triangle.get(i-1).get(j-1);
                }else{
                    sav[i][j]=Math.min(sav[i-1][j],sav[i-1][j-1])+triangle.get(i-1).get(j-1);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=1;i<=triangle.size();i++){
            if(sav[triangle.size()][i]<result){
                result = sav[triangle.size()][i];
            }
        }
        return result;
    }
}
