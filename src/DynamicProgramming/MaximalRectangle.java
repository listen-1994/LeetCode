package DynamicProgramming;

import java.util.Stack;

/**
 * LeetCode 第85题
 * 最大矩形
 */
public class MaximalRectangle {
    /*思路太复杂了，写不出来了
    int[][][] sav;

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int result = 0;
        sav = new int[matrix.length][matrix[0].length][3];
        if(matrix[0][0]=='1') {
            sav[0][0][0] = 0;
            sav[0][0][1] = 0;
            sav[0][0][2] = 1;
            result=1;
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == '1' && matrix[i - 1][0] == '1') {
                sav[i][0][0] = sav[i - 1][0][0];
                sav[i][0][1] = sav[i - 1][0][1];
                sav[i][0][2] = sav[i - 1][0][2] + 1;
            } else if (matrix[i][0] == '1' && matrix[i - 1][0] != '1') {
                sav[i][0][0] = i;
                sav[i][0][1] = 0;
                sav[i][0][2] = 1;
            } else {
                sav[i][0][0] = -1;
                sav[i][0][1] = -1;
                sav[i][0][2] = 0;
            }
            if (sav[i][0][2] > result) {
                result = sav[i][0][2];
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1' && matrix[0][i - 1] == '1') {
                sav[0][i][0] = sav[0][i - 1][0];
                sav[0][i][1] = sav[0][i - 1][1];
                sav[0][i][2] = sav[0][i - 1][2] + 1;
            } else if (matrix[0][i] == '1' && matrix[0][i - 1] != '1') {
                sav[0][i][0] = 0;
                sav[0][i][1] = i;
                sav[0][i][2] = 1;
            } else {
                sav[0][i][0] = -1;
                sav[0][i][1] = -1;
                sav[0][i][2] = 0;
            }
            if (sav[0][i][2] > result) {
                result = sav[0][i][2];
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i][j - 1] == '0' && matrix[i - 1][j] == '0') {
                        sav[i][j][0] = i;
                        sav[i][j][1] = j;
                        sav[i][j][2] = 1;
                        if (sav[i][j][2] > result) {
                            result = sav[i][j][2];
                        }
                        continue;
                    }
                    if (matrix[i][j - 1] == '0' && matrix[i - 1][j] != '0') {
                        sav[i][j][0] = sav[i - 1][j][0];
                        sav[i][j][1] = j;
                        sav[i][j][2] = i - sav[i][j][0] + 1;
                        if (sav[i][j][2] > result) {
                            result = sav[i][j][2];
                        }
                        continue;
                    }
                    if (matrix[i - 1][j] == '0' && matrix[i][j - 1] != '0') {
                        sav[i][j][0] = i;
                        sav[i][j][1] = sav[i][j - 1][1];
                        sav[i][j][2] = j - sav[i][j][1] + 1;
                        if (sav[i][j][2] > result) {
                            result = sav[i][j][2];
                        }
                        continue;
                    }
                    if (matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1') {
                        //上和左都不是0的情况，要考虑各种形状
                        if (sav[i - 1][j][0] < sav[i][j - 1][0] && sav[i - 1][j][1] > sav[i][j - 1][1]) {
                            int s2 = ((i + 1) - sav[i][j - 1][0]) * ((j + 1) - sav[i][j - 1][1]);
                            int s1 = ((i + 1) - sav[i - 1][j][0]) * ((j + 1) - sav[i - 1][j][1]);
                            if (s2 > s1) {
                                sav[i][j][0] = sav[i][j - 1][0];
                                sav[i][j][1] = sav[i][j - 1][1];
                                sav[i][j][2] = s2;
                            } else {
                                sav[i][j][0] = sav[i - 1][j][0];
                                sav[i][j][1] = sav[i - 1][j][1];
                                sav[i][j][2] = s1;
                            }
                        } else {
                            sav[i][j][0] = sav[i - 1][j][0];
                            sav[i][j][1] = sav[i][j - 1][1];
                            sav[i][j][2] = ((i + 1) - sav[i - 1][j][0]) * ((j + 1) - sav[i][j - 1][1]);
                        }
                    }
                } else {
                    sav[i][j][0] = -1;
                    sav[i][j][1] = -1;
                    sav[i][j][2] = 0;
                }
                if (sav[i][j][2] > result) {
                    result = sav[i][j][2];
                }
            }
        }
        for(int i=0;i<sav.length;i++){
            for(int j=0;j<sav[0].length;j++){
                System.out.print("i:"+i+"|"+"j:"+j+"|"+sav[i][j][0]+"|"+sav[i][j][1]+"|"+sav[i][j][2]);
                System.out.println();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'0','0','0'}, {'0','0','0'},{'1','1','1'}}));
    }
    */

    int sav[][];

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int result=0;
        int sav[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                sav[0][i] = 1;
            } else {
                sav[0][i] = 0;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    sav[i][j] = 0;
                } else {
                    sav[i][j] = sav[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int tmp=largestRectangle(sav[i]);
            if(tmp>result){
                result=tmp;
            }
        }
        return result;
    }

    public int largestRectangle(int[] heights){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()||heights[i]>=stack.peek()){
                stack.push(heights[i]);
            }else{
                int tmp=0;
                while(!stack.isEmpty()&&stack.peek()>heights[i]){
                    tmp++;
                    int out=stack.pop();
                    if(out*tmp>result){
                        result=out*tmp;
                    }
                }
                for(int j=0;j<=tmp;j++){
                    stack.push(heights[i]);
                }
            }
        }
        int tmp=0;
        while(!stack.isEmpty()){
            tmp++;
            int out=stack.pop();
            if(out*tmp>result){
                result=out*tmp;
            }
        }
        return result;
    }

    public static void main(String[] args){
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
