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

    public void insertAtFirst(Type element) {}

    public void insertAtLast(Type element) {}

    public Type deleteAtFirst() { return null; }

    public Type deleteAtLast() { return null; }

    public Node<Type> search(Type element) { return null; }

    public void insertBeforeElement(Type element) {}

    public void insertAfterElement(Type element) {}

    @Override
    public String toString() {
        return "";
    }

    public void display() {}

    public boolean isEmpty() { return size == 0; }

    public int countOfNodes() { return size; }
}
