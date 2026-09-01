class FirstUnique {

    Map<Integer, ListNode> nodeMap;
    ListNode head;
    ListNode tail;

    public FirstUnique(int[] nums) {
        nodeMap = new HashMap<>();

        head = new ListNode(0);
        tail = new ListNode(0);

        head.next = tail;
        tail.prev = head;

        for(int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if(head.next == tail) {
            return -1;
        }

        return head.next.value;
    }
    
    public void add(int value) {
        if(nodeMap.containsKey(value) && nodeMap.get(value) != null) {
            ListNode node = nodeMap.get(value);
            removeNode(node);
            nodeMap.put(value, null);
        }

        if(!nodeMap.containsKey(value)) {
            ListNode node = new ListNode(value);
            addToListTail(node);
            nodeMap.put(value, node);
        }    
    }

    public void addToListTail(ListNode node) {
        ListNode prev = tail.prev;
        ListNode next = tail;

        prev.next = node;
        node.prev = prev;
        
        next.prev = node;
        node.next = next;
    }

    public void removeNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

class ListNode {

    int value;
    ListNode prev;
    ListNode next;
    
    public ListNode(int value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}