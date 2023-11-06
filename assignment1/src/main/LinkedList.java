public class LinkedList<Type> {
    public static class Node<Type> {
        private Type element;
        private Node<Type> next;

        public Node(Type element, Node<Type> next) {
            this.element = element;
            this.next = next;
        }
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

    public void display() {}

    public boolean isEmpty() { return size == 0; }

    public int countOfNodes() { return size; }
}
