package DynamicProgramming;

public class WildcardMatching {

    boolean[][] sav;
    public boolean isMatch(String s ,String p){
        sav=new boolean[s.length()+1][p.length()+1];
        sav[0][0]=true;

        for(int i=1;i<=p.length();i++){
            for(int j=1;j<=s.length();j++){
                if(p.charAt(i-1)=='?'){
                    sav[j][i]=sav[j-1][i-1];
                }else if(p.charAt(i-1)=='*'){
                    for(int k=)
                }
            }
        }
    }


    public void core(String s,String p,int index_s,int index_p){
        if(index_s==s.length()&&index_p==p.length()){
            return;
        }
        if(index_s==s.length()&&index_p!=p.length()){
            if(p.charAt(index_p)!='*'){
                sav[index_s][index_p+1]=false;
            }else{
                sav[index_s][index_p+1]=true;
                core(s,p,index_s,index_p+1);
            }
        }
        if(index_p==p.length()&&index_s!=s.length()){
            sav[index_s+1][index_p]=false;
            core(s,p,index_s+1,index_p);
        }

        if(p.charAt(index_p)=='?'){
            sav[index_s+1][index_p+1]=sav[index_s][index_p];
        }
    }


    public static void main(String[] args){
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("aaaa","?aab"));
    }
}
