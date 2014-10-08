package Implementation;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length < 1|| matrix[0].length < 1)
        	return list;
        int buffer = 0;
        while(matrix.length - 2 * buffer > 0 && 
              matrix[0].length - 2 * buffer > 0) {
            int i = buffer, j = buffer;
            for(; j < matrix[0].length - buffer - 1; j ++) 
                list.add(matrix[i][j]);
            for(; i < matrix.length - buffer - 1; i++) 
                list.add(matrix[i][j]);
            if(matrix.length - 2 * buffer == 1 || matrix[0].length - 2 * buffer == 1) {
                list.add(matrix[i][j]);
                break;
            }
            for(; j > buffer; j-- )
                list.add(matrix[i][j]);
            for(; i > buffer; i--) 
                list.add(matrix[i][j]);
            buffer++;
        }
        return list;
    }
}
