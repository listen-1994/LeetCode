package DynamicProgramming;

/**
 * LeetCode 第53题
 * 最大子序和
 */
public class MaximumSubarray {
    int[] sav;
    public int maxSubArray(int[] nums){
        sav=new int[nums.length];
        sav[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(sav[i-1]<0){
                sav[i]=nums[i];
            }else{
                sav[i]=sav[i-1]+nums[i];
            }
        }
        int result = nums[0];
        for(int i=1;i<sav.length;i++){
            if(result<sav[i]){
                result=sav[i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        MaximumSubarray subarray = new MaximumSubarray();
        System.out.println(subarray.maxSubArray(new int[]{4,-1,2,1}));
    }
}
