public class Problem75 {

    /**
     * 这个是插入排序，效率太低 有空写一下头尾指针，三路快排是个啥哟
     * @param nums
     */
    public void sortColors(int[] nums) {
        int pointZero = 0;
        int pointOne = 0;
        int point = 0;

        while (point < nums.length) {
            if (nums[point] == 0) {
                exchange(nums, pointZero, point);
                pointZero++;
                pointOne++;
            } else if (nums[point] == 1) {
                exchange(nums, pointOne, point);
                pointOne++;
            }
            point++;
        }
    }

    public void exchange(int[] nums, int x, int y) {
        int normal = nums[y];
        for (int i = y; i > x; i--) {
            nums[i] = nums[i - 1];
        }
        nums[x] = normal;
    }

    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem75 problem75 = new Problem75();
        problem75.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
