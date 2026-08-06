class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }

}

class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        cache = new HashMap<>();
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        }

        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);

        if(cache.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node current = head.next;
        node.next = current;
        current.prev = node;
        head.next = node;
        node.prev = head;
    }
}
