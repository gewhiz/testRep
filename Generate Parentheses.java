//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

//For example, given n = 3, a solution set is:

//"((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    public List<String> generateParenthesis(int n) {
        
        ArrayList<String> result = new ArrayList<String>();
        if(n == 0)
            return result;
        if(n==1){
            result.add("()");
            return result;
        }
        
        rec(n, n, result, "");
        return result;
            
        
        
    }
    
    public void rec(int l, int r, ArrayList<String> result, String s)
    {
        if(l>r)return;
        if(l > 0)
            rec(l-1,r,result,s+"(");
        if(r > 0)
            rec(l,r-1,result,s+ ")");
        if(l == 0 && r == 0) result.add(s);
    }
}
