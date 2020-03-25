import java.util.ArrayDeque;

public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return new int[0];
        }
        ArrayDeque<Integer> sav = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i > k - 1) {
                if (sav.getFirst() == nums[i - k]) {
                    sav.removeFirst();
                }
            }
            if (sav.isEmpty()) {
                sav.addFirst(nums[i]);
            } else {
                while (!sav.isEmpty() && sav.getLast() < nums[i]) {
                    sav.removeLast();
                }
                sav.addLast(nums[i]);
            }
            if (i >= k - 1) {
                result[i - k + 1] = sav.getFirst();
            }
            System.out.println(sav);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem239 problem239 = new Problem239();
        int[] result = problem239.maxSlidingWindow(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}
