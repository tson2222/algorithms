package algoexpert.veryhard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Do not edit the class below except for the insertKeyValuePair,
// getValueFromKey, and getMostRecentKey methods. Feel free
// to add new properties and methods to the class.
class LeastRecentlyUsedCache {
    static class LRUCache {

        LinkedList<String> keys;

        Map<String, Integer> hashmap;

        int maxSize;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            hashmap = new HashMap<>();
            keys = new LinkedList<>();
        }

        public void insertKeyValuePair(String key, int value) {
            if (keys.size() == maxSize) {
                //evict LRU Node!
                String last = keys.getLast();
                //      System.out.println("Remove LRU Node: " + last);
                keys.remove(last);
                hashmap.remove(last);
            }
            if (!keys.contains(key)) {
                //add Node to HEAD since its the most recently used!
                keys.addFirst(key);
                //   System.out.println("Inserted into HEAD: " + keys.getFirst());
            }
            hashmap.put(key, value);
        }

        public LRUResult getValueFromKey(String key) {
            if (hashmap.containsKey(key)) {
                Integer value = hashmap.get(key);
                keys.remove(key); // remove so it can be inserted first again!
                keys.addFirst(key);
                return new LRUResult(true, value);
            }
            return new LRUResult(false, 0);
        }

        public String getMostRecentKey() {
            return keys.getFirst();
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        System.out.println(lruCache.getValueFromKey("a").value);
        lruCache.insertKeyValuePair("a", 1);
        System.out.println(lruCache.getValueFromKey("a").value);
        lruCache.insertKeyValuePair("a", 9001);
        System.out.println(lruCache.getValueFromKey("a").value);
        lruCache.insertKeyValuePair("b", 2);
        System.out.println(lruCache.getValueFromKey("a").value);
        System.out.println(lruCache.getValueFromKey("b").value);
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(lruCache.getValueFromKey("a").value);
        System.out.println(lruCache.getValueFromKey("b").value);
        System.out.println(lruCache.getValueFromKey("c").value);

    }

}
