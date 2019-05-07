package DynamicProgramming;
/**
 * LeetCode 第97题
 * 交错字符串
 */
public class InterleavingString {
    boolean sav[][][];

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        sav = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        sav[0][0][0] = true;
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0&&j==0){
                    sav[i][j][i+j]=true;
                    continue;
                }
                if(i==0){
                    sav[i][j][i+j]=sav[i][j-1][i+j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
                    continue;
                }
                if(j==0){
                    sav[i][j][i+j]=sav[i-1][j][i+j-1]&&s1.charAt(i-1)==s3.charAt(i+j-1);
                    continue;
                }
                sav[i][j][i+j]=(sav[i-1][j][i+j-1]&&s1.charAt(i-1)==s3.charAt(i+j-1))
                        ||sav[i][j-1][i+j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
            }
        }
        return sav[s1.length()][s2.length()][s3.length()];
    }
    public static void main(String[] args){
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("","abc","abc"));
    }
}
