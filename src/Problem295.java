import java.util.ArrayList;
import java.util.List;

public class Problem295 {
    class MedianFinder {

        Integer medianIndex;
        Boolean flag;
        List<Integer> numList;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            medianIndex = 0;
            flag = true;
            numList = new ArrayList<>();
        }

        public Boolean checkOddSize() {
            return !flag;
        }

        public Boolean checkEvenSize() {
            return flag;
        }

        public void addNum(int num) {
            if (checkOddSize()) {
                insertNum(num);
            } else {
                
            }
            flag = !flag;
        }

        public double findMedian() {
            return 0L;
        }

        public void insertNum(int num) {
            int beginSize = numList.size();
            for (int i = 0; i < beginSize; i++) {
                if (numList.get(i) >= num) {
                    numList.add(i, num);
                }
            }
            if (beginSize == numList.size()) {
                numList.add(num);
            }
        }

    }


}
