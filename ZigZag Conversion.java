//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//Write the code that will take a string and make this conversion given a number of rows:

//string convert(string text, int nRows);
//convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class Solution {
    public String convert(String s, int nRows) {
        char[] ch = s.toCharArray();
        int len = s.length();
        if(s.equals(""))
            return "";
        if(len<nRows || nRows == 1)
            return s;
        int line = (len-nRows)/(nRows-1);
        line++;

        if((len-nRows)%(nRows-1)>0)
        {
            line++;
        }
        char[][] map = new char[line][nRows];
        boolean flip = true;
        int t = 0;
        for(t = 0; t< nRows; t++)
        {
            map[0][t] = ch[t];
        }
        int k = t;
        for(int i = 1; i<line; i++)
        {
            if(flip)
            {
                flip = false;
                for(int j =nRows-2; j>=0; j--)
                {
                	if(k > len-1) break;
                    map[i][j] = ch[k];
                    k++;
                }
            }
            else
            {
                flip = true;
                for(int j =1; j< nRows; j++)
                {
                	if(k > len-1) break;
                    map[i][j] = ch[k];
                    k++;
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< nRows; i++)
        {
            for(int j = 0; j<line; j++)
            {
            	if(map[j][i] !='\0')
            		sb.append(map[j][i]);
            }
        }
        return sb.toString();
    }
}
