import java.util.HashMap;
import java.util.Map;

import structures.Point;

public class MaxPointsOnALine {
	 public int maxPoints(Point[] points) {
	        if (points == null || points.length == 0) return 0;  
		    int max = 1;  
		    double ratio = 0.0;  
		    for(int i = 0; i < points.length - 1; i++) {
		    	Map<Double, Integer> map = new HashMap<Double, Integer>();
		    	int samePotNum = 0;
		    	for(int j = i + 1; j < points.length; j++) {
		    		if(points[i].x == points[j].x && points[i].y == points[j].y) {
		    			samePotNum++;
		    			continue;
		    		}
		    		if(points[i].x == points[j].x)
		    			ratio = Double.MAX_VALUE;
		    		else if (points[i].y == points[j].y)
		    			ratio = 0.0;
		    		else 
		    			ratio = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
		    		if(map.containsKey(ratio)) 
		    			map.put(ratio, map.get(ratio) + 1);
		    		else
		    			map.put(ratio, 2);	    			
		    	}
		    	int localMax = 1;
		    	for(int num : map.values())
		    		localMax = Math.max(localMax, num);
		    	max = Math.max(max, localMax + samePotNum);
		    }
		    return max;
	    }
}


