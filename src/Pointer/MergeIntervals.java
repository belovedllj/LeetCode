package Pointer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import structures.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start - arg1.start;
			}
        	
        });
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size();) {
            Interval cur = intervals.get(i);
            if(pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
                intervals.remove(i);
                continue;
            }
            pre = intervals.get(i);
            i++;
            
        }
        return intervals;
    }
}
