public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point1 = 0;
        int point2 = 0;

        while (point2 < n && point1 < n + m) {
            while (nums2[point2] > nums1[point1] && point1 < m + point2) {
                point1++;
            }
            mvNums1(nums1, point1, m + point2 + 1);
            nums1[point1] = nums2[point2];
            point2++;
            point1++;
        }
    }

    private void mvNums1(int[] nums1, int point, int size) {
        for (int i = size-1; i >point; i--) {
            nums1[i] = nums1[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        Problem88 problem88 = new Problem88();
        problem88.merge(nums1, 3, nums2, 3);
    }
}
