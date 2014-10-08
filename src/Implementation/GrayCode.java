package Implementation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>(1 << n);
        if(n < 0) return res;
        res.add(0);
        for(int i = 0; i < n; i++) {
        	int add = 1 << i;// add is also the size
        	for(int j = add - 1; j >= 0; j--) {
        		res.add(res.get(j) + add);
        	}
        }
        return res;
    }
}
