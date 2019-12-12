import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Problem132 {
    public int minCut(String s) {
        if (null==s||s.length()==0||s.length()==1){
            return 0;
        }
        Boolean[][] palindromeArray = new Boolean[s.length()][s.length()];
        Boolean[][] visited = new Boolean[s.length()][s.length()];
        for (int i = 0;i<s.length();i++){
            for (int j =i;j<s.length();j++){
                checkPalindrome(i,j,palindromeArray,visited,s);
            }
        }
        Integer[][] minSave = new Integer[s.length()][s.length()];
        for (int i = 0;i<s.length();i++){
            minSave[i][i] = 1;
        }
        Integer result =  caculateMin(0,s.length()-1,palindromeArray,minSave);
        return result-1;
    }

    private boolean checkPalindrome(Integer a,Integer b,Boolean[][] palindromeArray,Boolean[][] visited,String s){
        if (a-1==b){
            return true;
        }
        if (a.equals(b)){
            palindromeArray[a][b] = true;
            visited[a][b] = true;
            return true;
        }
        if (s.charAt(a)!=s.charAt(b)){
            palindromeArray[a][b] = false;
            palindromeArray[b][a] = false;
            visited[a][b] = true;
            visited[b][a] = true;
            return false;
        }
        if (null!=visited[a][b]&&visited[a][b]){
            return palindromeArray[a][b];
        }
        Boolean subResult = false;
        if (null==visited[a+1][b-1]||visited[a+1][b-1].equals(false)){
            subResult = checkPalindrome(a+1,b-1,palindromeArray,visited,s);
        }
        visited[a][b] =true;
        visited[b][a] =true;
        palindromeArray[a][b] = subResult;
        palindromeArray[b][a] = palindromeArray[a][b];
        //System.out.println(a+":"+b);
        return palindromeArray[a][b];
    }

    private Integer caculateMin(Integer a,Integer b,Boolean[][] palindromeArray,Integer[][] minSave){
        if (palindromeArray[a][b]){
            return 1;
        }
        Integer result = Integer.MAX_VALUE;
        for (int i = a;i<=b;i++){
            if (palindromeArray[a][i]){
                Integer tmpResult = 1;
                if (minSave[i+1][b]!=null){
                    tmpResult+=minSave[i+1][b];
                }else {
                    tmpResult+=caculateMin(i+1,b,palindromeArray,minSave);
                }
                result = Math.min(result,tmpResult);
            }
        }
        minSave[a][b] = result;
        return result;
    }

    public static void main(String[] args){
        Problem132 problem132 = new Problem132();
        Integer result = problem132.minCut("abbab");
        System.out.println(result);
    }

}
