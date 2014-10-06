//Given an array of strings, return all groups of strings that are anagrams.

//Note: All inputs will be in lower-case.


import java.util.*;

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        List<String> fresh = new ArrayList<String>();
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        for(String str : strs)
        {
            String map = sortStr(str);
            if(ht.containsKey(map))
            {
                res.add(str);
                int c = ht.get(map);
                c++;
                ht.put(map, c);
            }
            else
            {
                fresh.add(str);
                ht.put(map, 0);
            }
        }
        for(String str : fresh)
        {
            String map = sortStr(str);
            if(ht.containsKey(map) && (ht.get(map)>0))
            {
                res.add(str);
            }
        }
        return res;
    }
    
    public String sortStr(String str)
    {
        char[] map = str.toCharArray();
	         Arrays.sort(map);
	         return new String(map);
    }
}
