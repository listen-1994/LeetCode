package DynamicProgramming;

/**
 * LeetCode 第96题
 * 不同的二叉搜索树
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if(n<=1){
            return 1;
        }
        int[] sav = new int[n+1];
        sav[0]=1;
        sav[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                sav[i]+=sav[j-1]*sav[i-j];
            }
        }
/*        for(int i=0;i<n+1;i++){
            System.out.println(sav[i]);
        }*/
        return sav[n];
    }
    public static void main(String[] args){
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));
    }
}
