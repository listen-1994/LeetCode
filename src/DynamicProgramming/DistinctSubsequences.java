package DynamicProgramming;

/**
 * LeetCode 第115题
 * 不同的子序列
 */
public class DistinctSubsequences {
    int sav[][];

    public int numDistinct(String s, String t) {
        sav = new int[s.length() + 1][t.length() + 1];
        for(int i=0;i<=s.length();i++){
            sav[i][0]=1;
        }
        for (int j = 1; j <= t.length(); j++) {
            for (int i = j; i <= s.length(); i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    sav[i][j]=sav[i-1][j]+sav[i-1][j-1];
                } else {
                    sav[i][j]=sav[i-1][j];
                }
            }
        }
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=t.length();j++){
                System.out.print(sav[i][j]+" ");
            }
            System.out.println();
        }
        return sav[s.length()][t.length()];
    }

    public static void main(String[] args){
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("rabbbit","rabbit"));
    }
}
