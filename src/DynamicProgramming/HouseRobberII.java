package DynamicProgramming;

/**
 * LeetCode 第213题
 * 打家劫舍II
 */
public class HouseRobberII {
    /**
     * 其实就两种情况，0到n-1和1到n，转化为HouseRobberI问题解决
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums,0),rob(nums,1));
    }
    public int rob(int[] nums,int k){
        int result = 0;
        int sav[]=new int[nums.length+3];
        if(k==0){
            for(int i=0;i<nums.length-1;i++){
                sav[i+3]=Math.max(sav[i],sav[i+1])+nums[i];
            }
            return Math.max(sav[nums.length],sav[nums.length+1]);
        }else{
            for(int i=1;i<nums.length;i++){
                sav[i+3]=Math.max(sav[i],sav[i+1])+nums[i];
            }
            return Math.max(sav[nums.length+1],sav[nums.length+2]);
        }
    }
    public static void main(String[] args){
        HouseRobberII houseRobber = new HouseRobberII();
        System.out.println(houseRobber.rob(new int[]{2,3,2}));
    }
}
