//Given a collection of numbers, return all possible permutations.

//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].



public List<List<Integer>> permute(int[] num) {
	        int n = num.length;
	        if(num == null || num.length == 0)
	            return null;
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> ini = new ArrayList<Integer>();
	        ini.add(num[0]);
	        res.add(ini);
	        if(num.length == 1)
	        {
	        	return res;
	        }
	        else
	        	res.clear();
	        int[] preArr = new int[n-1];
	        for(int i = 0; i< n-1; i++)
	        {
	        	preArr[i] = num[i];
	        }
	        
	        List<List<Integer>> pre = permute(preArr);
	        int last = num[n-1];
	        for(List<Integer> list : pre){
	        	res.addAll(insert(last, list));
	        }
	        
	        return res;
	    }
	    
	    public List<List<Integer>> insert(int n,  List<Integer> list)
	    {
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();
	    	for(int i = 0; i<=list.size(); i++)
	    	{
	    		List<Integer> temp = new ArrayList<Integer>();
	    		temp.addAll(list);
	    		temp.add(i, n);
	    		res.add(temp);
	    	}
	    	return res;
	    }
