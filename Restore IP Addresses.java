//Given a string containing only digits, restore it by returning all possible valid IP address combinations.

//For example:
//Given "25525511135",

//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


public class Solution {
    public List<String> restoreIpAddresses(String s) {
                List<String> res = new ArrayList<String>();
        if(s.length()<4)
        {
            return res;
        }
        for(int i = 1; i< 4; i++)
        {
            if(isValidIp(s, 0, i))
            {
                String ip1 = s.substring(0,i);
                for(int j = i+1; j<i+4; j++)
                {
                    if(isValidIp(s, i, j))
                    {
                        String ip2 = s.substring(i, j);
                        for(int k = j+1; k<j+4; k++)
                        {
                            if(isValidIp(s, j, k))
                            {
                                String ip3 = s.substring(j, k);
                                if(s.length()-k > 3)
                                {
                                	continue;
                                }
                                int m = k; 
                                int n = s.length();                               
                                    if(isValidIp(s, m, n)){
                                    String ip4 = s.substring(m);
                                    StringBuilder sb = new StringBuilder(ip1);
                                    sb.append(".");
                                    sb.append(ip2);
                                     sb.append(".");
                                    sb.append(ip3);
                                     sb.append(".");
                                    sb.append(ip4);
                                    res.add(sb.toString());
                                    }
                                
                            }
                        }
                        
                    }
                }
            }
        }
        return res;
    }
    
    
    boolean isValidIp(String s, int pre, int pos)
    {
        if(pos <= pre)
			 return false;
        if(pos> s.length())
            return false;
        if(pos - pre>3)
            return false;
        String sub = s.substring(pre, pos);
        if(sub.startsWith("0") && sub.length()>1)
        	return false;
        int k = Integer.parseInt(sub);
        if(k<0||k>255)
            return false;
        return true;
    }
}
