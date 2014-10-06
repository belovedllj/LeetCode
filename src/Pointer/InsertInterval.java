package Pointer;

import java.util.List;

import structures.Interval;

// no extra space
public class InsertInterval {
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        if(intervals == null || newInterval == null) return intervals;
	        boolean isFoundStart = false;
	        Interval pre = null;
	        if(intervals.size() == 0) {
	            intervals.add(newInterval);
	            return intervals;
	        }
	        for(int i = 0; i < intervals.size();) {
	            Interval cur = intervals.get(i);
	            if(!isFoundStart) { //  not find end;
	                if(newInterval.start < cur.start) {
	                    isFoundStart = true;
	                    intervals.add(i, newInterval);
	                    if(i == 0) pre = newInterval; // first node
	                    else pre = intervals.get(--i); // back to pre
	                }
	                i++; continue;
	            } else { // found
	                if(pre.end >= cur.start) {
	                   pre.end = Math.max(pre.end, cur.end);
	                   intervals.remove(i);
	                   continue;
	                }
	                pre = intervals.get(i);
	                i++;
	            }
	        }
	        if(!isFoundStart) { // add at last
	            pre = intervals.get(intervals.size() - 1);
	            intervals.add(newInterval);
	            if(pre.end >= newInterval.start) {
	                pre.end = Math.max(pre.end, newInterval.end);
	                intervals.remove(intervals.size() - 1);
	            }
	        }
	        return intervals;
	    }
}
