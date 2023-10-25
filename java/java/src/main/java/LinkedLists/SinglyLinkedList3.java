package LinkedLists;

public class SinglyLinkedList3<Type> {
    public class Node<Type> {
        private Type element;
        private Node<Type> next;

        public Node(Type element, Node<Type> next) {
            this.element = element;
            this.next = next;
        }

        public Type getElement() { return element; }

        public Node<Type> getNext() { return next; }

        public void setNext(Node<Type> node) { this.next = node; }
    }

    private Node<Type> head;
    private Node<Type> tail;
    private int size;

    public SinglyLinkedList3() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() { return size; }

    public Boolean isEmpty() { return size == 0; }

    public Type getFirst() {
        if (isEmpty()) { return null; }
        return head.getElement();
    }

    public Type getLast() {
        if (isEmpty()) { return null; }
        return tail.getElement();
    }

    public void addFirst(Type element) {
        head = new Node<>(element, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(Type element) {
        Node<Type> newTail = new Node<>(element, null);
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        tail.setNext(newTail);
        tail = newTail;
        size++;
    }

    public Type removeFirst() {
        if (isEmpty()) { return null; }
        Type deletedElement = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) { tail = null; }
        return deletedElement;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<Type> node = head;
        while (node != null) {
            sb.append(node.getElement());
            sb.append(", ");

            node = node.getNext();
        }

        sb.append("]");

        return sb.toString();
    }
}
