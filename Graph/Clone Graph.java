//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

//Nodes are labeled uniquely.

import java.util.*;
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Hashtable<Integer, UndirectedGraphNode> ht = new Hashtable<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        UndirectedGraphNode k = new UndirectedGraphNode(node.label);
        ht.put(k.label, k);
        List< UndirectedGraphNode> list = new ArrayList< UndirectedGraphNode>();
        for( UndirectedGraphNode nn : node.neighbors)
        {
            if(ht.containsKey(nn.label)){
                UndirectedGraphNode mm = ht.get(nn.label);
                list.add(mm);
            }
            else
            {
                list.add(cloneGraph(nn));
            }
        }
        k.neighbors = list;
        
        return k;
    }
}
