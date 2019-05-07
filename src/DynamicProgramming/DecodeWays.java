package DynamicProgramming;

/**
 * LeetCode 第91题
 * 解码方法
 */
public class DecodeWays {
    int [] sav;
    public int numDecodings(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1&&s.charAt(0)!='0'){
            return 1;
        }
        if(s.charAt(0)=='0'){
            return 0;
        }

        sav=new int[s.length()+1];
        sav[0]=1;
        sav[1]=1;
        boolean flag = true;

        if(s.charAt(0)=='1'||s.charAt(0)=='0'){
            flag=false;
        }
        for(int i=2;i<=s.length();i++){
            if(flag&&s.charAt(i-1)=='0'){
                return 0;
            }
            if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                flag=false;
            }else{
                flag=true;
            }

            if(s.charAt(i-1)=='0'){
                sav[i]=sav[i-2];
                continue;
            }
            if(s.charAt(i-2)=='1'){
                sav[i]=sav[i-2]+sav[i-1];
                continue;
            }
            if(s.charAt(i-2)=='2'&&s.charAt(i-1)<='6'&&s.charAt(i-1)>=1){
                sav[i]=sav[i-2]+sav[i-1];
                continue;
            }
            sav[i]=sav[i-1];
        }
/*        for(int i=0;i<=s.length();i++){
            System.out.println(sav[i]);
        }*/
        return sav[s.length()];
    }

    public static void main(String[] args){
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("10"));
    }
}
