package Implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
        List<String> list = new ArrayList<String>();
        if(words == null || words.length < 1)
            return list;
        int i = 0;
        while(i < words.length) {
            int spaceCounter = 0;
            int spaceLeft = L;
            List<String> curWordsList = new LinkedList<String>();
            // assuming no word is longer than L
            while(i < words.length) {
            	String curWord = words[i];
            	if(!curWordsList.isEmpty() && curWord.length() + 1 > spaceLeft)
            		break;
                
                i++;
                if(curWordsList.isEmpty()) { // first word
                    spaceLeft -= curWord.length();
                } else {
                    spaceLeft = spaceLeft - (curWord.length() + 1);
                    spaceCounter += 1;
                }
                curWordsList.add(curWord);
            }
            spaceCounter += spaceLeft;
            int spaceNum = curWordsList.size() - 1;
            if(spaceNum == 0) { // only one word
            	StringBuffer strBuf = new StringBuffer();
            	strBuf.append(curWordsList.get(0));
            	for(int j = 0; j < spaceCounter; j++) {
            		strBuf.append(' ');
            	}
            	list.add(strBuf.toString());
            	if(i >= words.length) break; // last word
            } else {
            	StringBuffer strBuf = new StringBuffer();
            	if(i >= words.length) { // last line
            		for(int k = 0; k < curWordsList.size(); k++) {
            			if(k == 0) { // first word in line
                			strBuf.append(curWordsList.get(k));
                		} else {
                			strBuf.append(" " + curWordsList.get(k));
                		}
            		}            		
            		int lastLineSpaceLeft = L - strBuf.length();
            		for(int j = 0; j < lastLineSpaceLeft; j++) {
            			strBuf.append(' ');
            		}
            		list.add(strBuf.toString());
            		break;
            	} else { // normal line
            		int extraSpace = spaceCounter % spaceNum;
            		int spaceBetween = spaceCounter / spaceNum;
            		for(int k = 0; k < curWordsList.size(); k++) {
            			if(k == 0) 
            				strBuf.append(curWordsList.get(k));
            			else {
            				int curSpaceBetween = spaceBetween;
            				if(extraSpace != 0) {
            				    curSpaceBetween++;
            				    extraSpace--;
            				}
            				for(int p = 0; p < curSpaceBetween; p++) {
            					strBuf.append(' ');
            				}
            				strBuf.append(curWordsList.get(k));
            			}
            		}
            		list.add(strBuf.toString());
            	}            	
            }
        }
        return list;
    }
}
