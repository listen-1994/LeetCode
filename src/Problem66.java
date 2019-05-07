/**
 * LeetCode 第66题 加一
 * 简单
 * 数组 数学
 */
public class Problem66 {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int point = digits.length-1;
        while(point>=0){
            if(digits[point]==9){
                digits[point]=0;
                flag = true;
            }else{
                digits[point]++;
                flag = false;
                break;
            }
            point--;
        }
        if(flag){
            int[] result = new int[digits.length+1];
            result[0]=1;
            return result;
        }else{
            return digits;
        }
    }
}
