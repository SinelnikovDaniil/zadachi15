public class Zadanie8 {
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public void Queue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node removedNode = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }

        return removedNode.data;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return front.data;
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
