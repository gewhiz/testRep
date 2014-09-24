//Reverse Words in a String

//Given an input string, reverse the string word by word.

//For example,
//Given s = "the sky is blue",
//return "blue is sky the".

//click to show clarification.

public class Solution {
    public String reverseWords(String s) {
    String t = new StringBuilder(s).reverse().toString();
    String[] arr = t.split(" ");
    
    StringBuilder builder = new StringBuilder();
    for(String str : arr) {
    	str = str.trim();
    	if(str.length()>0)
    	{
    		str = new StringBuilder(str).reverse().toString();
    		builder.append(str+" ");
    	}
    }
    return builder.toString().trim();
    
}

}
