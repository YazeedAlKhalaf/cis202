package LinkedLists;

public class SinglyLinkedList4<Type> {
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
    private int size;

    public SinglyLinkedList4() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() { return size; }

    public Boolean isEmpty() { return size == 0; }

    public Type first() {
        if (isEmpty()) { return null; }
        return head.getElement();
    }

    public Type last() {
        if (isEmpty()) { return null; }

        Node<Type> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getElement();
    }

    public void addFirst(Type element) {
        head = new Node<>(element, head);
        size++;
    }

    public void addLast(Type element) {
        Node<Type> newTail = new Node<>(element, null);
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        Node<Type> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(newTail);
        size++;
    }

    public Type removeFirst() {
        if (isEmpty()) { return null; }
        Type deletedElement = head.getElement();
        head = head.getNext();
        size--;
        return deletedElement;
    }

    public Type removeLast() {
        if (isEmpty()) { return null; }
        if (size == 1) {
            Type deletedElement = head.getElement();
            head = null;
            size--;
            return deletedElement;
        }

        Node<Type> beforeCurrentNode = null; // will be before last node.
        Node<Type> currentNode = head; // will be last node.
        while (currentNode.getNext() != null) {
            beforeCurrentNode = currentNode;
            currentNode = currentNode.getNext();
        }

        beforeCurrentNode.setNext(null);
        size--;

        return currentNode.getElement();
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
