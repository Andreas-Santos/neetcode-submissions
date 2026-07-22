class MinStack {

    Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val, val);
            return;
        }
        
        Node temp = head;
        head = new Node(val, Math.min(head.min, val), temp);
    }
    
    public void pop() {
        if(head == null) return;

        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

class Node {
    int val;
    int min;
    Node next;

    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
        this.next = null;
    }
}