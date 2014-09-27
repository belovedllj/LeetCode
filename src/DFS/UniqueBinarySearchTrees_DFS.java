package DFS;

public class UniqueBinarySearchTrees_DFS {
	public int numTrees(int n) {		 
        switch (n) {
            case 0: return 1;
            case 1: return 1;
            case 2: return 2;
        }
        
        int numOfTree = 0;
        for(int i = 1; i <= n; i++) {
            numOfTree += numTrees(n - i) * numTrees(i - 1);
        }
        return numOfTree;            
    }
}
