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

        Node<Type> newNode = new Node<>(element, null);

        Node<Type> tail = getTail();
        tail.setNext(newNode);

        size++;
    }

    public Type deleteAtFirst() {
        if (size == 0) { return null; }

        Node<Type> nodeToBeDeleted = head;

        if (size == 1) {
            head = null;
        } else {
            head = nodeToBeDeleted.getNext();
        }

        size--;

        return nodeToBeDeleted.getElement();
    }

    public Type deleteAtLast() {
        if (size == 0) { return null; }

        Node<Type> nodeToBeDeleted = null;

        if (size == 1) {
            nodeToBeDeleted = head;
            head = null;
        } else {
            Node<Type> beforeTail = null;
            Node<Type> tail = head;
            while (tail.getNext() != null) {
                beforeTail = tail;
                tail = tail.getNext();
            }

            beforeTail.setNext(null);
            nodeToBeDeleted = tail;
        }

        size--;

        return nodeToBeDeleted.getElement();
    }

    public Node<Type> search(Type element) {
        Node<Type> searchedNode = head;
        while (searchedNode != null) {
            if (searchedNode.getElement().equals(element)) { break; }

            searchedNode = searchedNode.getNext();
        }

        return searchedNode;
    }

    public boolean insertBeforeElement(Type element) { return false; }

    public boolean insertAfterElement(Type elementToAddAfter, Type newElement) {
        Node<Type> searchedNode = search(elementToAddAfter);
        if (searchedNode == null) { return false; }

        Node<Type> newNode = new Node<>(newElement, searchedNode.getNext());
        searchedNode.setNext(newNode);

        return true;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

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

    private Node<Type> getTail() {
        Node<Type> tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        return tail;
    }
}
