package LinkedLists;

public class SinglyLinkedList<Type> {
    public static class Node<Type> {
        private Type element;
        private Node<Type> next;

        public Node(Type t, Node<Type> n) {
            element = t;
            next = n;
        }

        public Type getElement() { return element; }

        public Node<Type> next() { return next; }

        public void setNext(Node<Type> n) { next = n; }
    }

    private Node<Type> head = null;
    private Node<Type> tail = null;
    private int size = 0;

    public int getSize() { return size; }

    public boolean isEmpty() { return  size == 0; }

    public Type first() {
        if (isEmpty()) { return null; }
        return head.getElement();
    }

    public Type last() {
        if (isEmpty()) { return null; }
        return tail.getElement();
    }

    public void addFirst(Type t) {
        head = new Node<>(t, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(Type t) {
        Node<Type> newest = new Node<>(t, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }

        tail = newest;
        size++;
    }

    public Type removeFirst() {
        if (isEmpty()) { return null; }
        Type headValue = head.getElement();
        head = head.next();
        size--;

        return headValue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<Type> initNode = head;
        while (initNode != null) {
            sb.append(initNode.getElement());
            sb.append(", ");
            initNode = initNode.next();
        }

        return sb + "]";
    }
}
