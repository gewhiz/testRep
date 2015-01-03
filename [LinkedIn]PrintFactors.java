
List<List<Integer>> PrintFactors(int n){
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	if(isPrime(n)){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(n);
		res.add(list);
		return res;
	}
	HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
	List<Integer> list = ArrayList<Integer>();
	list.add(1);
	list.add(n);
	hs.add(list);
	for(int i = 2; i<=n/2; i++){
		if(n%i == 0){
			List<List<Integer>> nex = printFactors(n/i);
			for(List<Integer> ll : nex){
				if(ll.get(0) == 1){
					ll.remove(0);					
				}
				List<Integer> mm = new ArrayList<Integer>();
				mm.add(i);
				mm.addAll(ll);
				if(!hs.contains(mm))
					hs.add(mm);
			}
		}
	}
	res.addAll(hs);
	return res;
}

boolean isPrime(int n){
	int c = 0;
	for(int i = 1; i<=n; i++){
		if(n%i == 0)
			c++;
		if(c > 2)
			return false;
	}
	return true;
}
