public class Queue<Type> {
    public static class Node<Type> {
        private Type data;
        private Node<Type> next;

        public Node(Type data, Node<Type> next) {
            this.data = data;
            this.next = next;
        }

        public Type getData() { return data; }

        public Node<Type> getNext() { return next; }

        public void setNext(Node<Type> newNext) { this.next = newNext; }
    }

    private Node<Type> front;
    private Node<Type> tail;
    private int size;

    public Queue() {
        this.front = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(Type data) {
        Node<Type> newNode = new Node<>(data, null);

        if (isEmpty()) {
            front = newNode;
        } else {
            tail.setNext(newNode);
        }

        tail = newNode;
        size++;
    }

    public Type dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node<Type> nodeToDequeue = front;
        this.front = front.getNext();

        if (front == null) { tail = null; }

        size--;

        return nodeToDequeue.getData();
    }

    public Type front() {
        if (isEmpty()) {
            return null;
        }

        return front.getData();
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        if (front == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Node<Type> curr = front;
        do {
            sb.append(curr.getData());
            if (curr.getNext() != null) { sb.append(", "); }
            curr = curr.getNext();
        } while(curr != null);

        sb.append(" ]");

        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }
}