package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
        if(strs == null) return null;
        if (strs.length <= 1) {
            List<String> list = new ArrayList<String>();
            return list;
        }
        Map<String, ArrayList<String>> sortedStrsMap = new HashMap<String, ArrayList<String>>();
        // sorted String map to original String List (if the list contains more than 2, output list)
        for (String orignalStr : strs) {
            String sortedArr = sorted(orignalStr);
            if(sortedStrsMap.isEmpty() || !sortedStrsMap.containsKey(sortedArr)) {
                ArrayList<String> orginalStrsList = new ArrayList<String>();
                orginalStrsList.add(orignalStr);
                sortedStrsMap.put(sortedArr, orginalStrsList);
            }
            else {
                ArrayList<String> orginalStrsList = sortedStrsMap.get(sortedArr);
                orginalStrsList.add(orignalStr);
            }
        }
        /*
         * the api here need to remember !!!!!!!!!!!!!!  values(); addAll(Collection<? extends E> c)
         */
        List<String> anagramsList = new ArrayList<String>();
        for(ArrayList<String> orginalStrsList : sortedStrsMap.values()) {
            if (orginalStrsList.size() >= 2) { // find anagrams
                anagramsList.addAll(orginalStrsList);
            }
        }
        return anagramsList;
    }
    
    private String sorted(String a){
        char[] aCharArray = a.toCharArray();
        Arrays.sort(aCharArray);
        return new String(aCharArray);
    }
}
