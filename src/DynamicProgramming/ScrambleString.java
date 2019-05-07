package DynamicProgramming;
/**
 * LeetCode 第87题
 * 扰乱字符串
 * 参考博客：https://www.cnblogs.com/ariel-dreamland/p/9159396.html
 */

/**递归版本，超时
 * public class Solution {
 *     public boolean isScramble(String s1, String s2) {
 *         if(s1.length()==1&&s2.length()==1){
 *             return s1.equals(s2);
 *         }
 *         boolean result = false;
 *         for(int i=1;i<s1.length();i++){
 *             result=result|| (isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i),s2.substring(i)))
 *                     ||(isScramble(s1.substring(0,i),s2.substring(s2.length()-i))&&isScramble(s1.substring(i),s2.substring(0,s2.length()-i)));
 *         }
 *         return result;
 *     }
 * }
 */

/**
 * 将递归版本基础之上修改为DP版本
 */
public class ScrambleString {

    int [][][][] sav;
    public boolean isScramble(String s1, String s2) {
        sav=new int [s1.length()][s1.length()+1][s2.length()][s2.length()+1];
        return core(s1,s2,0,s1.length(),0,s2.length());
    }

    public boolean core(String s1, String s2,int s1_begin,int s1_end,int s2_begin,int s2_end){
        //单个字符
        if(s1_begin+1==s1_end&&s2_begin+1==s2_end){
            if(s1.substring(s1_begin,s1_end).equals(s2.substring(s2_begin,s2_end))){
                sav[s1_begin][s1_end][s2_begin][s2_end]=1;
                return true;
            }else{
                sav[s1_begin][s1_end][s2_begin][s2_end]=2;
                return false;
            }
        }
        boolean result = false;
        for(int i=1;i<s1_end-s1_begin;i++){
            if(sav[s1_begin][s1_begin+i][s2_begin][s2_begin+i]==0){
                if(core(s1,s2,s1_begin,s1_begin+i,s2_begin,s2_begin+i)){
                    sav[s1_begin][s1_begin+i][s2_begin][s2_begin+i]=1;
                }else{
                    sav[s1_begin][s1_begin+i][s2_begin][s2_begin+i]=2;
                }
            }
            if(sav[s1_begin+i][s1_end][s2_begin+i][s2_end]==0){
                if(core(s1,s2,s1_begin+i,s1_end,s2_begin+i,s2_end)){
                    sav[s1_begin+i][s1_end][s2_begin+i][s2_end]=1;
                }else{
                    sav[s1_begin+i][s1_end][s2_begin+i][s2_end]=2;
                }
            }
            if(sav[s1_begin][s1_begin+i][s2_end-i][s2_end]==0){
                if(core(s1,s2,s1_begin,s1_begin+i,s2_end-i,s2_end)){
                    sav[s1_begin][s1_begin+i][s2_end-i][s2_end]=1;
                }else{
                    sav[s1_begin][s1_begin+i][s2_end-i][s2_end]=2;
                }
            }
            if(sav[s1_begin+i][s1_end][s2_begin][s2_begin+(s1_end-s1_begin-i)]==0){
                if(core(s1,s2,s1_begin+i,s1_end,s2_begin,s2_begin+(s1_end-s1_begin-i))){
                    sav[s1_begin+i][s1_end][s2_begin][s2_begin+(s1_end-s1_begin-i)]=1;
                }else{
                    sav[s1_begin+i][s1_end][s2_begin][s2_begin+(s1_end-s1_begin-i)]=2;
                }
            }
            result=result||(sav[s1_begin][s1_begin+i][s2_begin][s2_begin+i]==1&&sav[s1_begin+i][s1_end][s2_begin+i][s2_end]==1)||(sav[s1_begin][s1_begin+i][s2_end-i][s2_end]==1&&sav[s1_begin+i][s1_end][s2_begin][s2_begin+(s1_end-s1_begin-i)]==1);
        }
        if(result){
            sav[s1_begin][s1_end][s2_begin][s2_end]=1;
        }else{
            sav[s1_begin][s1_end][s2_begin][s2_end]=2;
        }
        return result;
    }

    public static void main(String[] args){
        ScrambleString scrambleString=new ScrambleString();
        System.out.println(scrambleString.isScramble("abcde","caebd"));
    }
}