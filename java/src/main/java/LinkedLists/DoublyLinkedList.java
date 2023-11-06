package LinkedLists;

public class DoublyLinkedList<Type> {
    public static class Node<Type> {
        private Type element;
        private Node<Type> prev;
        private Node<Type> next;

        public Node(Type element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        }

        public Type getElement() { return element; }

        public void setElement(Type element) { this.element = element; }

        public Node<Type> getPrev() { return prev; }

        public void setPrev(Node<Type> prev) { this.prev = prev; }

        public Node<Type> getNext() { return next; }

        public void setNext(Node<Type> next) { this.next = next; }
    }

    private Node<Type> head;
}
