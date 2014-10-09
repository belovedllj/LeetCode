package Math;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return probability(m - 1, n - 1);
    }
    
    private int probability(int row, int column) {
        if (row < 0 || column < 0) return 0;
        if (row == 0 || column == 0) return 1;
        int co = Math.min(row, column);
        int ro = Math.max(row, column);
        long value = 1;
        for (int i = 1; i <= co; i++) {
            value *= (ro + co + 1) - i;
            value /= i;
        }
        return (int)value;
    }
}
