import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第57题 插入区间
 * 排序 数组
 */
public class Problem57 {
    public static class Interval {
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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        boolean flag = false;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > newInterval.start) {
                intervals.add(i, newInterval);
                if (merge1(intervals, i - 1)) {
                    merge(intervals, i - 1);
                } else {
                    merge(intervals, i);
                }
                flag = true;
                break;
            }
        }
        if (!flag) {
            intervals.add(newInterval);
            merge1(intervals, intervals.size() - 2);
        }
        return intervals;
    }

    public void merge(List<Interval> intervals, int index) {
        if (index < 0 || index >= intervals.size() - 1) {
            return;
        }
        Interval node1 = intervals.get(index);
        Interval node2 = intervals.get(index + 1);
        int start = node1.start;
        int end;
        if (node2.start <= node1.end) {
            if (node1.end > node2.end) {
                end = node1.end;
                intervals.remove(index);
                intervals.remove(index);
                intervals.add(index, new Interval(start, end));
                merge(intervals, index);
            } else {
                end = node2.end;
                intervals.remove(index);
                intervals.remove(index);
                intervals.add(index, new Interval(start, end));
            }
        }
    }

    public boolean merge1(List<Interval> intervals, int index) {
        if (index < 0 || index >= intervals.size() - 1) {
            return false;
        }
        Interval node1 = intervals.get(index);
        Interval node2 = intervals.get(index + 1);
        int start = node1.start;
        if (node2.start <= node1.end) {
            int end = Math.max(node1.end, node2.end);
            intervals.remove(index);
            intervals.remove(index);
            intervals.add(index, new Interval(start, end));
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Problem57 problem57 = new Problem57();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));
        List<Interval> result = problem57.insert(list, new Interval(2, 5));
    }
}
