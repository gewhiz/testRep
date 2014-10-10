//Given a digit string, return all possible letter combinations that the number could represent.

//A mapping of digit to letters (just like on the telephone buttons) is given below.

//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//Although the above answer is in lexicographical order, your answer could be in any order you want.

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null)
            return res;
        if(digits.length() == 0)
        {
             res.add(digits);
                return res;
        }
        int k = 0;
        while(k<digits.length())
        {
            char d = digits.charAt(k);
            String m = getMap(d);
            
            List<String> list = new ArrayList<String>();
           for(int i = 0; i<m.length(); i++)
            {
                char ch = m.charAt(i);
                if(res.size()>0){
                for(String str : res)
                {
                    list.add(str+ch);
                }
                }
                else
                {              	
                	list.add(Character.toString(ch));
                }
            }
            res = list;
            k++;
        }
        return res;
    }
    
    String getMap(char n)
    {
        String res = "";
        switch (n){
        case '1': 
            res = "?"; break;
        case '2':
            res = "abc"; break;
        case '3':
            res = "def"; break;
        case '4':
            res = "ghi"; break;
        case '5':
            res = "jkl"; break;
        case '6':
            res = "mno"; break;
        case '7':
            res = "pqrs"; break;
        case '8':
            res = "tuv"; break;
        case '9':
            res = "wxyz"; break;
        default:
            res = " "; break;
        }
        return res;
    }
}
