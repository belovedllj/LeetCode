package Implementation;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int layer = 0; layer < length / 2; layer++){
            int first = layer;
            int last = length - 1 - layer;
            for (int i = first; i < last; i++) {
                int top = matrix[first][i];
                matrix[first][i] = matrix[last + first - i][first];
                matrix[last + first - i][first] = matrix[last][last + first - i];
                matrix[last][last + first - i] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}
