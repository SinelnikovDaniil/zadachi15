public class Zadanie7 {
    private class Node {
        int x;
        int y;
        Node prev;
        Node next;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.prev = null;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public void Deque() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void addFront(int x, int y) {
        Node newNode = new Node(x, y);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public void addRear(int x, int y) {
        Node newNode = new Node(x, y);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    public Node removeFront() {
        if (isEmpty()) {
            return null;
        }

        Node removedNode = front;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        return removedNode;
    }

    public Node removeRear() {
        if (isEmpty()) {
            return null;
        }

        Node removedNode = rear;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        return removedNode;
    }

    public void printDeque() {
        Node current = front;
        while (current != null) {
            System.out.println("(" + current.x + ", " + current.y + ")");
            current = current.next;
        }
    }
}
