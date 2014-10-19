/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/


public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == end)
            return 0;
        Set<String> used = new HashSet<String>();
        used.add(start);
        int path = 0;
       
        Queue<String> que = new LinkedList<String>();
        que.add(start);
        int nex = 0;
        int cur = 1;
        while(!que.isEmpty())
        {
        	String str = que.remove();       	
            	for (int i = 0; i < str.length(); ++i)
            	{
            		for (char k  = 'a'; k <= 'z'; ++k)
            		{
            			StringBuilder next = new StringBuilder(str);
            			next.setCharAt(i, k);
            			String mm = next.toString();
            			if(mm.equals(end) )
        					return path+2;
            			if(dict.contains(mm) && !used.contains(mm))
            			{
            				nex++;
            				que.add(mm);
            				used.add(mm);
            			}
            		}
            	}
            	cur--;
            	if(cur == 0)
            	{
            		cur = nex;
            		nex = 0;
            		path++;
            	}
 
        }
        
        return 0;
    }

}
