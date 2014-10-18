/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all 
requirements up front before implementing one.

*/

public class Solution {
    public boolean isNumber(String s) {
        try {
        s = s.trim();
        int n = s.length();
        if ( n == 0 || (s.charAt(n-1) != '.' && (s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )) ) {
            return false;
        }
        double i = Double.parseDouble(s);
        return true;
    }
    catch (NumberFormatException e) {
        return false;
    }
        
    }
}
