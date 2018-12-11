package DynamicProgramming;

/**
 * LeetCode 第44题
 * 通配符匹配
 */
public class WildcardMatching {

    boolean[][] sav;
    public boolean isMatch(String s ,String p){
        sav=new boolean[s.length()+1][p.length()+1];
        sav[0][0]=true;

        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                sav[0][i]=sav[0][i-1];
            }else{
                sav[0][i]=false;
            }
        }
        for(int i=1;i<=p.length();i++){
            for(int j=1;j<=s.length();j++){
                if(p.charAt(i-1)=='?'){
                    sav[j][i]=sav[j-1][i-1];
                }else if(p.charAt(i-1)=='*'){
                    for(int k=j;k>=0;k--){
                        sav[j][i]=sav[j][i]||sav[k][i-1];
                    }
                }else{
                    if(p.charAt(i-1)==s.charAt(j-1)){
                        sav[j][i]=sav[j-1][i-1];
                    }else{
                        sav[j][i]=false;
                    }
                }
            }
        }
        //print(sav);
        return sav[s.length()][p.length()];
    }

    public void print(boolean[][] sav){
        for(int i=0;i<sav.length;i++){
            for(int j=0;j<sav[i].length;j++){
                System.out.print(sav[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("adceb","*a*b"));
    }
}
