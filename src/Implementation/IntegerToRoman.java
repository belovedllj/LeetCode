package Implementation;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public String intToRoman(int num) {
    	Map<Character, String> romanNumberConverterMap = buildRomanNumberConverterMap();
    	Map<Integer, HashMap<Character, Character>> romanNumberDigitMap =
    			buildRomanNumberDigitMap();
    	String araboNum = Integer.toString(num);
    	StringBuffer romanNum = new StringBuffer();
        int digitNumber = araboNum.length();
        for (int digit = digitNumber, index = 0; digit > 0; digit--, index++) {
        	char numberChar = araboNum.charAt(index);
        	if (numberChar == '0') continue;
        	HashMap<Character, Character> mapOfDigits = romanNumberDigitMap.get(digit);
        	String numberOnThisDigit = romanNumberConverterMap.get(numberChar);
        	for (int i = 0; i < numberOnThisDigit.length(); i++) {
        		romanNum.append(mapOfDigits.get(numberOnThisDigit.charAt(i)));        		
        	}
        }
        return romanNum.toString();
    }
    
    private Map<Character, String> buildRomanNumberConverterMap() {
		 Map<Character, String> romanNumberConverterMap = new HashMap<Character, String>();
		 romanNumberConverterMap.put('1', "1");
		 romanNumberConverterMap.put('2', "11");
		 romanNumberConverterMap.put('3', "111");
		 romanNumberConverterMap.put('4', "15");
		 romanNumberConverterMap.put('5', "5");
		 romanNumberConverterMap.put('6', "51");
		 romanNumberConverterMap.put('7', "511");
		 romanNumberConverterMap.put('8', "5111");
		 romanNumberConverterMap.put('9', "10");
		 return romanNumberConverterMap; 
	}
	private Map<Integer, HashMap<Character, Character>> buildRomanNumberDigitMap() {
		 Map<Integer, HashMap<Character, Character>> romanNumberDigitMap = 
				 new HashMap<Integer, HashMap<Character, Character>>();
		 HashMap<Character, Character> mapOfOnes = new HashMap<Character, Character>();
		 HashMap<Character, Character> mapOfTens = new HashMap<Character, Character>();
		 HashMap<Character, Character> mapOfHunds = new HashMap<Character, Character>();
		 HashMap<Character, Character> mapOfThous = new HashMap<Character, Character>();
		 
		 mapOfOnes.put('1', 'I');
		 mapOfOnes.put('5', 'V');
		 mapOfOnes.put('0', 'X');

		 mapOfTens.put('1', 'X');
		 mapOfTens.put('5', 'L');
		 mapOfTens.put('0', 'C');

		 mapOfHunds.put('1', 'C');
		 mapOfHunds.put('5', 'D');
		 mapOfHunds.put('0', 'M');

		 mapOfThous.put('1', 'M');
	 
		 romanNumberDigitMap.put(1, mapOfOnes);
		 romanNumberDigitMap.put(2, mapOfTens);
		 romanNumberDigitMap.put(3, mapOfHunds);
		 romanNumberDigitMap.put(4, mapOfThous);
		 
		 return romanNumberDigitMap; 
	}
}
