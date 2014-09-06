package Stack;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        // http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
        	return 0;
        int[][] heights = new int[matrix.length][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == '0') 
        			heights[i][j] = 0;
        		else {
        			if(i == 0) heights[i][j] = 1;
        			else heights[i][j] = heights[i - 1][j] + 1;
        		}
        	}
        }
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++) {
        	maxArea = Math.max(maxArea, maxAreaInHist(heights[i]));
        }
        return maxArea;
    }
    
    private int maxAreaInHist(int[] height){
    	Stack<Integer> stack = new Stack<Integer>();
    	int i = 0;
    	int maxArea = 0;
    	while(i < height.length){
    	    if(stack.isEmpty() || height[stack.peek()] <= height[i]){
    	        stack.push(i++);
    	    }else {
    	        int t = stack.pop();
    	        maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
    	    }
    	}
    	return maxArea;
    }
}
