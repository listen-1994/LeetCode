import java.util.ArrayList;
import java.util.List;

public class Problem89 {
    public List<Integer> grayCode(int n) {
        int[] subResult = new int[n];
        List<Integer> result = new ArrayList<>((int) Math.pow(2, n));
        if(n==0){
            result.add(0);
            return result;
        }
        grayCode(subResult, n - 1, 0, result);
        return result;
    }

    private void grayCode(int[] subResult, int begin, int end, List<Integer> result) {
        if (begin == end) {
            result.add(array2Integer(subResult));
            reverse(subResult, begin);
            result.add(array2Integer(subResult));
            return;
        }
        grayCode(subResult, begin - 1, end, result);
        reverse(subResult, begin);
        grayCode(subResult, begin - 1, end, result);
    }

    private Integer array2Integer(int[] subResult) {
        if (subResult == null) {
            return 0;
        }

        Integer integer = 0;
        for (int i = 0; i < subResult.length; i++) {
            if (subResult[i] == 1) {
                integer += (int) Math.pow(2, i);
            }
        }

        return integer;
    }

    private void reverse(int[] subResult, int index) {
        if (subResult[index] == 0) {
            subResult[index] = 1;
            return;
        }
        if (subResult[index] == 1) {
            subResult[index] = 0;
        }
    }

    public static void main(String[] args) {
        Problem89 problem89 = new Problem89();
        System.out.println(problem89.grayCode(2));
    }

    private void printArray(int[] subResult) {
        for (Integer i : subResult) {
            System.out.println(i);
        }
    }

}
