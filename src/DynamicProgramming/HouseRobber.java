package DynamicProgramming;

/**
 * LeetCode 第198题
 * 打家劫舍
 */
public class HouseRobber {
    public int rob(int[] nums){
        int result = 0;
        int sav[]=new int[nums.length+3];
        for(int i=0;i<nums.length;i++){
            sav[i+3]=Math.max(sav[i],sav[i+1])+nums[i];
        }
        return Math.max(sav[nums.length+2],sav[nums.length+1]);
    }
    public static void main(String[] args){
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{1,2,3,1}));
    }
}
