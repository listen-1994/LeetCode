package DynamicProgramming;

public class WildcardMatching {


    public boolean isMatch(String s ,String p){
        String p2=deleteStar(p);
        int count = countChar(p2);
        return core(s,deleteStar(p2),0,0,count);
    }

    public boolean onlyStar(String p,int index_p){
        return index_p==p.length()-1&&p.charAt(p.length()-1)=='*';
    }

    public boolean core(String s,String p ,int index_s,int index_p,int count){
        System.out.println(index_s+":"+index_p);
        if(index_p==p.length()&&index_s==s.length()){
            return true;
        }
        if(index_p==p.length()&&index_s!=s.length()){
            return false;
        }
        if(index_s==s.length()&&index_p!=p.length()&&!onlyStar(p,index_p)){
            return false;
        }
        if(index_s+count>s.length()){
            return false;
        }
        if(p.charAt(index_p)=='?'){
            return core(s,p,index_s+1,index_p+1,count-1);
        }else if(p.charAt(index_p)=='*'){
            return core(s,p,index_s,index_p+1,count)||core(s,p,index_s+1,index_p,count);
        }else {
            if(s.charAt(index_s)==p.charAt(index_p)){
                return core(s,p,index_s+1,index_p+1,count-1);
            }else {
                return false;
            }
        }
    }

    public String deleteStar(String p){
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)!='*'){
                sb.append(p.charAt(i));
                flag=false;
            }else{
                if(!flag){
                    sb.append(p.charAt(i));
                    flag=true;
                }
            }
        }
        return sb.toString();
    }
    public int countChar(String p){
        int result = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)!='*'){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb","**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
        ));
    }
}
