// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

// For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

//     I can be placed before V (5) and X (10) to make 4 and 9. 
//     X can be placed before L (50) and C (100) to make 40 and 90. 
//     C can be placed before D (500) and M (1000) to make 400 and 900.

// Given an integer, convert it to a roman numeral.

// https://leetcode.com/problems/integer-to-roman/description/

class Solution {
    private static final Map<Integer, String> ROMAN_SYMBOLS = new HashMap<>();

        static {
            ROMAN_SYMBOLS.put(1, "I");
            ROMAN_SYMBOLS.put(5, "V");
            ROMAN_SYMBOLS.put(10, "X");
            ROMAN_SYMBOLS.put(50, "L");
            ROMAN_SYMBOLS.put(100, "C");
            ROMAN_SYMBOLS.put(500, "D");
            ROMAN_SYMBOLS.put(1000, "M");
        }
          
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int place = 1;

        while(num > 0){
            int digit = num % 10;
            num /= 10;
            String symbols = ROMAN_SYMBOLS.get(place);
            String romanInsert = "";
            if(digit <= 3){
                for(int i = 0; i < digit; i++){
                    romanInsert += symbols;
                }
            } 
            else if(digit == 4){
                romanInsert = symbols + ROMAN_SYMBOLS.get(place * 5);
            }
            else if(digit >= 5 && digit <= 8){
                romanInsert = ROMAN_SYMBOLS.get(place * 5);
                for (int i = 0; i < digit - 5; i++) {
                    romanInsert += symbols;
                }
            }
            else if(digit == 9){
                romanInsert = symbols + ROMAN_SYMBOLS.get(place * 10);
            }
            sb.insert(0, romanInsert);
            place *= 10;
        }
        return sb.toString();
    }
}

// Second Approach

class Solution {
    public String intToRoman(int num) {
        int []v = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String []k = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < v.length; i++){
            sb.append(k[i].repeat(num / v[i]));
            num %= v[i];
        }
        return sb.toString();
    }
}
