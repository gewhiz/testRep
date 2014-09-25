public class Solution {
    public List<String> generateParenthesis(int n) {
        
        ArrayList<String> list = new ArrayList<String>();
    Stack<String> stack = new Stack<String>();
    Stack<Integer> validationStack = new Stack<Integer>();
    
    stack.push("(");
    validationStack.push(0);
    while(stack.size() != 0)
    {
        String s = stack.pop();
        int v = validationStack.pop();
        if(s.length() == n * 2)
        {
            list.add(s);
            continue;
        }
        if(s.length() - v < n)
        {
            stack.push(s + "(");
            validationStack.push(v);
        }
        if(2 * v < s.length())
        {
            stack.push(s + ")");
            validationStack.push(v+1);
        }
    }
    return list;
        
    }
 
}
