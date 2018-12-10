package DynamicProgramming;

class LongestValidParentheses {
    int result = 0;
    int[][] sav;

    public int longestValidParentheses(String s) {
        sav = new int[s.length() + 1][5];
        sav[0][0] = 0;
        sav[0][1] = 0;
        sav[0][2] = 0;
        sav[0][3] = 0;
        sav[0][4] = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            System.out.println("i:"+i);
            if(s.charAt(i-1)=='('){
                if(sav[i-1][1]==0){
                    sav[i][1]=1;
                    sav[i][0]=sav[i-1][2];
                    sav[i][2]=0;
                    sav[i][3]=i-1;
                    sav[i][4]=sav[i-1][4];
                }else{
                    sav[i][1]=sav[i-1][1]+1;
                    sav[i][0]=sav[i-1][0];
                    sav[i][2]=sav[i-1][2];
                    sav[i][3]=sav[i-1][3];
                    sav[i][4]=sav[i-1][4];
                }
            }else if(s.charAt(i-1)==')') {
                if (sav[i - 1][1] == 1) {
                    sav[i][2] = sav[i - 1][0] + 2;
                    sav[i][0] = sav[sav[i - 1][3]][0];
                    sav[i][1] = 0;
                    sav[i][3] = sav[sav[i - 1][3]][3];
                    sav[i][4] = sav[i - 1][4];
                } else if (sav[i - 1][1] > 1) {
                    sav[i][1] = 0;
                    sav[i][0] = sav[i - 1][0];
                    sav[i][2] = 2;
                    sav[i][3] = sav[i - 1][3];
                    sav[i][4] = sav[i - 1][1] - 1;
                } else if (sav[i - 1][1] == 0) {
                    if (sav[i - 1][4] > 1) {
                        sav[i][2] = sav[i - 1][2] + 2;
                        sav[i][0] = sav[i - 1][0];
                        sav[i][1] = 0;
                        sav[i][3] = sav[i - 1][3];
                        sav[i][4] = sav[i - 1][4]-1;
                    } else if (sav[i - 1][4] == 1) {
                        sav[i][2] = sav[i - 1][2] + sav[i - 1][0] + 2;
                        sav[i][1] = 0;
                        sav[i][0] = sav[sav[i - 1][3]][0];
                        sav[i][3] = sav[sav[i - 1][3]][3];
                        sav[i][4] = sav[sav[i - 1][3]][4];
                    } else if (sav[i - 1][4] == 0) {
                        sav[i][0] = 0;
                        sav[i][1] = 0;
                        sav[i][2] = 0;
                        sav[i][3] = 0;
                        sav[i][4] = 0;
                    }
                }
            }
            if(sav[i][2]>result){
                result=sav[i][2];
            }
            System.out.println("0:"+sav[i][0]+"|"+"1:"+sav[i][1]+"|"+"2:"+sav[i][2]+"|"+"3:"+sav[i][3]+"|"+"4:"+sav[i][4]);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParentheses longest = new LongestValidParentheses();
        System.out.println(longest.longestValidParentheses("((()))())"));
    }
}