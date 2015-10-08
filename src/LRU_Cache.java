import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

public class LRU_Cache {
    private Map<Integer,Integer> map;
    public LRU_Cache(final int capacity){
        //16: the default size of map; 0.75:default load factor; true for access-order,false for insertion-order
        map = new LinkedHashMap<Integer,Integer>(16, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size()>capacity;
            }
        };
    }
    public int get(int key){
        return map.getOrDefault(key,-1);
    }

    public void set(int key,int value){
        map.put(key,value);
    }
}
