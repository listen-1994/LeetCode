package Stack;

import java.util.Stack;

/**
 * LeetCode 第84题
 * 柱状图中的最大矩形
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights){
        if(heights.length==0){
            return 0;
        }
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
}
