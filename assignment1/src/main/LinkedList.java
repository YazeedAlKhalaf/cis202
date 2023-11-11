public class LinkedList<Type> {
    public static class Node<Type> {
        private Type element;
        private Node<Type> next;

        public Node(Type element, Node<Type> next) {
            this.element = element;
            this.next = next;
        }

        public Type getElement() { return element; }

        public void setElement(Type element) { this.element = element; }

        public Node<Type> getNext() { return next; }

        public void setNext(Node<Type> next) { this.next = next; }
    }

    private Node<Type> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtFirst(Type element) {
        if (head == null) {
            head = new Node<>(element, null);
        } else {
            Node<Type> newNode = new Node<>(element, head);
            head = newNode;
        }

        size++;
    }

    public void insertAtLast(Type element) {
        if (head == null) {
            insertAtFirst(element);
            return;
        }

        Node<Type> tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        Node<Type> newNode = new Node<>(element, null);
        tail.setNext(newNode);

        size++;
    }

    public Type deleteAtFirst() { return null; }

    public Type deleteAtLast() { return null; }

    public Node<Type> search(Type element) { return null; }

    public void insertBeforeElement(Type element) {}

    public void insertAfterElement(Type element) {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Node<Type> curr = head;
        do {
            sb.append(curr.getElement());
            if (curr.getNext() != null) { sb.append(", "); }
            curr = curr.getNext();
        } while(curr != null);

        sb.append(" ]");

        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }

    public boolean isEmpty() { return size == 0; }

    public int countOfNodes() { return size; }
}
