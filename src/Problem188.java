import javax.swing.plaf.IconUIResource;

public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        if (k==0||null==prices||prices.length==1){
            return 0;
        }

        int[][][] sav = new int[prices.length][prices.length][k+1];
        boolean[][][] flag = new boolean[prices.length][prices.length][k+1];
        return core(0,prices.length-1,prices,k,sav,flag);
    }

    private Integer core(int begin,int end,int[] prices,int k,int[][][] sav,boolean[][][] flag){
        if (begin==end||k==0){
            return 0;
        }
        if (flag[begin][end][k]){
            return sav[begin][end][k];
        }

        int result = 0;

    }

}
