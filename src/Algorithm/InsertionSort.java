package Algorithm;

import utils.ArrayUtils;

/**
 * 插入排序
 */
public class InsertionSort {
    public void sort(Integer[] nums){
        ArrayUtils.printArray(nums);
    }

    public static void main(String[] args){
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(new Integer[]{1,2,3,4,5,6});
    }
}
