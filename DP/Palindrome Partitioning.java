/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
  */


public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for(int i=0; i<s.length(); i++){
            result[i+1] = new ArrayList<List<String>>();
            char c = s.charAt(i);
            for(int j=0; j<=i; j++){
                if(j == i)
                    pair[j][i] = true;
                else{
                    if(s.charAt(j) != c)
                        continue;
                    if(j == i-1)
                        pair[j][i] = true;
                    else
                        pair[j][i] = pair[j+1][i-1];
                }
                if(pair[j][i]){
                    String str = s.substring(j, i+1);
                    for(List<String> r : result[j]){
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i+1].add(ri);
                    }
                }
            }
        }

        return result[len];      
    }
}
