import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem149 {
    public int maxPoints(int[][] points) {
        int result = 0;

        Map<Integer, Integer> xResult = new HashMap<>();
        Map<Integer, Integer> yResult = new HashMap<>();
        Map<String, Integer> zResult = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            if (null == xResult.get(x)) {
                xResult.put(x, 0);
            }
            if (null == yResult.get(y)) {
                yResult.put(y, 0);
            }
            int tmpX = xResult.get(x) + 1;
            int tmpY = yResult.get(y) + 1;
            result = Math.max(result, tmpX);
            result = Math.max(result, tmpY);
            xResult.put(x, tmpX);
            yResult.put(y, tmpY);

            Set<String> keySet = new HashSet<>();
            for (int j = i - 1; j >= 0; j--) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x == x2 || y == y2) {
                    continue;
                }
                int molecule = y2 - y;
                int denominator = x2 - x;

                int greatestCommonDivisor = greatestCommonDivisor(molecule, denominator);
                molecule = molecule / greatestCommonDivisor;
                denominator = denominator / greatestCommonDivisor;
                int b = y - x / denominator * molecule;

                String key = molecule + ":" + denominator + ":" + b;
                if (keySet.contains(key)) {
                    continue;
                }
                keySet.add(key);
                if (null == zResult.get(key)) {
                    zResult.put(key, 1);
                }
                int tmpZ = zResult.get(key) + 1;
                result = Math.max(result, tmpZ);
                zResult.put(key, tmpZ);
            }
        }
        return result;
    }

    private int greatestCommonDivisor(int a, int b) {
        int max = Math.abs(a);
        int min = Math.abs(b);
        if (max < min) {
            int tmp = max;
            max = min;
            min = tmp;
        }
        int tmp = max % min;
        if (tmp == 0) {
            return min;
        }
        return greatestCommonDivisor(min, tmp);
    }

    public static void main(String[] args) {
        Problem149 problem149 = new Problem149();
        int result = problem149.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
        System.out.println(result);
    }
}
