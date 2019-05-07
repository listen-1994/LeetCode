package DynamicProgramming;

/**
 * LeetCode 第72题
 * 编辑距离
 */
public class EditDistance {
    int sav[][];
    public int minDistance(String word1, String word2) {
        sav=new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<=word1.length();i++){
            sav[i][0]=i;
        }
        for(int i=1;i<=word2.length();i++){
            sav[0][i]=i;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    sav[i][j]=Math.min(Math.min(sav[i-1][j],sav[i][j-1]),sav[i-1][j-1])+1;
                }else{
                    sav[i][j]=Math.min(Math.min(sav[i-1][j]+1,sav[i][j-1]+1),sav[i-1][j-1]);
                }
            }
        }
        return sav[word1.length()][word2.length()];
    }

    public static void main(String[] args){
        EditDistance distance = new EditDistance();
        System.out.println(distance.minDistance("intention","execution"));
    }
}
