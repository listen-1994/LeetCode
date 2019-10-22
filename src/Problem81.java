public class Problem81 {
    public boolean search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return false;
        }

        //查询
        Integer point = findPoint(nums);
        if (point.equals(-1)) {
            return false;
        }

        if (nums[nums.length - 1] == target) {
            return true;
        }

        if (point == nums.length - 1) {
            return search(nums, 0, nums.length - 1, target);
        }

        if (nums[nums.length - 1] < target) {
            return search(nums, 0, point, target);
        }

        if (nums[nums.length - 1] > target) {
            return search(nums, point + 1, nums.length - 1, target);
        }

        return false;
    }


    private Integer findPoint(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    private Boolean search(int[] nums, Integer begin, Integer end, Integer target) {
        if (begin.equals(end)) {
            return target.equals(nums[begin]);
        }
        if (end < begin) {
            return false;
        }

        Integer half = (begin + end) / 2;
        if (nums[half] < target) {
            return search(nums, half + 1, end, target);
        }
        if (target.equals(nums[half])) {
            return true;
        }
        if (nums[half] > target) {
            return search(nums, begin, half - 1, target);
        }

        return false;
    }

    public static void main(String[] args) {
        Problem81 problem81 = new Problem81();
        int[] nums = new int[]{1, 3};
        Boolean result = problem81.search(nums, 1);
        System.out.println(result);
    }

}
