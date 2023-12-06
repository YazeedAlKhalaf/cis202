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

    public Type pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node<Type> nodeToPop = top;
        top = top.getNext();
        size--;

        return nodeToPop.getData();
    }

    public Type top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.getData();
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }
}

class EmptyStackException extends Exception {}
