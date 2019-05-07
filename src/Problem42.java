import java.util.Stack;

/**
 * LeetCode 第42题 接雨水
 * 栈 数组 双指针
 */
public class Problem42 {

    /**
     * 采用双指针的解法
     * https://blog.csdn.net/qq_41231926/article/details/82682179
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < height.length - 1 && height[left + 1] >= height[left]) {
            left++;
        }
        while (right > 0 && height[right - 1] >= height[right]) {
            right--;
        }
        while (left < right) {
            int rightHeight = height[right];
            int leftHeight = height[left];
            if (leftHeight <= rightHeight) {
                while (left < right) {
                    left++;
                    if (height[left] < leftHeight) {
                        result += leftHeight - height[left];
                    } else {
                        break;
                    }
                }
            } else {
                while (left < right) {
                    right--;
                    if (height[right] < rightHeight) {
                        result += rightHeight - height[right];
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Problem42 problem42 = new Problem42();
        System.out.println(problem42.trap(new int[]{2,0,2}));
    }
}