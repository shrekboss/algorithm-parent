package org.crayzer.leetcode.editor.en.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_56_合并区间 {

    class Interval {
        int start, end;

        Interval(int[] intervals) {
            this.start = intervals[0];
            this.end = intervals[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }

    class Solution {

        public int[][] merge(int[][] intervals) {
            List<Interval> intervallist = new ArrayList<>();
            for (int[] interval : intervals) {
                intervallist.add(new Interval(interval));
            }
            intervallist.sort(new IntervalComparator());
            LinkedList<Interval> merged = new LinkedList<>();
            for (Interval interval : intervallist) {
                if (merged.isEmpty() || merged.getLast().end < interval.start) merged.add(interval);
                else merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
            int i = 0;
            int[][] resut = new int[merged.size()][2];
            for (Interval interval : merged) {
                resut[i] = interval.toArray();
                i++;
            }
            return resut;
        }
    }
}
