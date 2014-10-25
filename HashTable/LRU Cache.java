/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
*/

import java.util.LinkedHashMap;
public class LRUCache {

private static int cap;
Map <Integer, Integer> lmap;
public LRUCache(int capacity) {
    this.cap= capacity;
    lmap = new LinkedHashMap(capacity,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry eldest){
            return size() > cap;
        }
    };

}

public int get(int key) {
    if(lmap.containsKey(key)){
        return lmap.get(key);
    }
    return -1;
}

public void set(int key, int value) {
    lmap.put(key,value);
}
}
