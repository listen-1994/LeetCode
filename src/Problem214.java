public class Problem214 {
    public String shortestPalindrome(String s) {
        if (null==s||s.length()<2){
            return s;
        }
        String result = new String(s);
        int index = s.length();
        while(index>=0){
            Boolean median = index%2==0;

            int trueIndex = (index-1)/2;

            int subResult = 0;
            if (median){
                subResult = checkPalindrome(s,trueIndex,trueIndex+1);
            }else{
                subResult = checkPalindrome(s,trueIndex-1,trueIndex+1);
            }
            if (subResult!=-1){
                result =completeString(s,subResult);
                break;
            }
            index--;
        }
        return result;
    }

    private String completeString(String s,int needIndex){
        StringBuilder stringBuilder = new StringBuilder(s);

        int j = needIndex;
        while(j>0){
            stringBuilder.insert(0,s.charAt(s.length()-j));
            j--;
        }
        return stringBuilder.toString();
    }

    private int checkPalindrome(String s,int left,int right){
        Boolean flag = true;
        while(left>=0&&right<s.length()){
            flag = flag&&s.charAt(left)==s.charAt(right);
            if (!flag){
                break;
            }
            left--;
            right++;
        }
        if (!flag){
            return -1;
        }
        return s.length()-right;
    }

    public static void main(String[] args){
        Problem214 problem214 = new Problem214();
        String result = problem214.shortestPalindrome("aacecaaa");
        System.out.println(result);
    }
}