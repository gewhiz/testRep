// You are asked to write a max_slice function 
//which takes as an input an array of integers, 
//and returns the slice with the largest sum of the elements

class Solution {
  static void Main(string[] args) {
    int[] a = new int[]{1,3,4, -10, 2, 4,5};
    //int[] a = new int[]{-3, -1, -4, -10, -2, -4, -5};
    //int[] a = new int[]{-1, 20, -10, 10, 9, 6, -55, 10};
    int[] result = getMaxSlice(a);
    foreach(int k in result)
     {
      Console.WriteLine(k);
    }
  }
  
  static int[] getMaxSlice(int[] A)
  {
     int j = 0; 
	    int s = A[0];
	    int max = A[0];
	    int startInd = 0;
	    int endInd = 0;
	    for(int i = 1; i<A.length; i++)
	    {
	    	if(A[i] > s+A[i]){
	    		s = A[i];
	    		j = i;
	    	}
	    	else{
	    		s += A[i];
	    	}	        
	        if(s>max){
	            max = s;
	            startInd = j;
	            endInd = i;
	        }
	    }
	    return getSlice(A, startInd, endInd);
  }
  
  static int[] getSlice(int[] A, int i, int j)
  {
    int len = j-i+1;
    int[] result = new int[len];
    int c = 0;
    for(int k = i;k<=j;k++)
    {
        result[c] = A[k];
        c++;
    }
    return result;
  }
}

