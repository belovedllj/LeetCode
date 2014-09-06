package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
        if(height == null || height.length < 1) return 0;
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < height.length; i++) {
			if(stack.isEmpty())
				stack.push(i);
			else {
				while(!stack.isEmpty() && height[i] < height[stack.peek()]) {
					int curHeiPos = stack.pop();
					if(!stack.isEmpty())
					    maxArea = Math.max(maxArea, height[curHeiPos] * (i - stack.peek() - 1));
					else 
						maxArea = Math.max(maxArea, height[curHeiPos] * i);
				}
				stack.push(i);
			}
		}
		while(!stack.empty()) {
			int curHeiPos = stack.pop();
			if(!stack.isEmpty())
			    maxArea = Math.max(maxArea, height[curHeiPos] * (height.length - stack.peek() - 1));
			else 
				maxArea = Math.max(maxArea, height[curHeiPos] * height.length);
		}
		return maxArea;	
    }
}
