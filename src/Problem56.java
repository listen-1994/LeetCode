import java.util.ArrayList;
import java.util.List;

public class Problem56 {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        while (!intervals.isEmpty()) {
            Interval smallest = intervals.get(0);
            int index = 0;
            for (int i = 1; i < intervals.size(); i++) {
                if (smallest.start > intervals.get(i).start) {
                    smallest = intervals.get(i);
                    index = i;
                }
            }
            result.add(smallest);
            join(result);
            intervals.remove(index);
        }
        return result;
    }

    public void join(List<Interval> result) {
        if (result.size() < 2) {
            return;
        }
        Interval last = result.get(result.size() - 1);
        Interval secondLast = result.get(result.size() - 2);

        if (last.start < secondLast.end) {
            int start = secondLast.start;
            int end = Math.max(secondLast.end, last.end);
            Interval interval = new Interval(start, end);
            result.remove(result.size() - 1);
            result.remove(result.size() - 1);
            result.add(interval);
        }
    }
}
