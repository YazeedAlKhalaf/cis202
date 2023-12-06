public class Stack<Type> {
    public static class Node<Type> {
        private Type data;
        private Node<Type> next;

        public Node(Type data, Node<Type> next) {
            this.data = data;
            this.next = next;
        }

        public Type getData() { return data; }

        public Node<Type> getNext() { return next; }
    }

    private Node<Type> top;
    private int size = 0;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(Type data) {
        Node<Type> newNode = new Node<>(data, top);
        top = newNode;
        size++;
    }

    public Type pop() {
        if (isEmpty()) {
            return null;
        }

        Node<Type> nodeToPop = top;
        top = top.getNext();
        size--;

        return nodeToPop.getData();
    }

    public Type top() {
        if (isEmpty()) {
            return null;
        }

        return top.getData();
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        if (top == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Node<Type> curr = top;
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