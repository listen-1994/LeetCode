package Arrays;

/**
 * LeetCode 第27题
 * 移除元素
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i=0;
		int j=0;
		while(i<nums.length) {
			if(nums[i]==val) {
				i++;
			}else {
				nums[j]=nums[i];
				i++;
				j++;
			}
		}
		return j;
	}
	
	public static void main(String[] args) {
		RemoveElement removeElement = new RemoveElement();
		System.out.println(removeElement.removeElement(new int[]{3,2,2,3},3));
	}
}
