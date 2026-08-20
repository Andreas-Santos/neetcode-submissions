class LRUCache {

    int capacity;
    Map<Integer, ListNode> cache;
    ListNode head;
    ListNode tail;
    // Map<Key, ListNode>

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void insertNode(ListNode node) {
        ListNode next = head.next;
        ListNode prev = head;
        node.next = next;
        node.prev = head;
        head.next = node;
        next.prev = node;
    }

    public void removeNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;

        removeNode(cache.get(key));
        insertNode(cache.get(key));

        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            ListNode temp = cache.get(key);
            removeNode(temp);
        }

        ListNode node = new ListNode(key, value);
        cache.put(key, node);
        insertNode(node);

        if(cache.size() > capacity) {
            ListNode lru = tail.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }
}

class ListNode {

    int key;
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}