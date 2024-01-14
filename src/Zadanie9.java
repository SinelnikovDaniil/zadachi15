public class Zadanie9 {
    private class Node {
        char symbol;
        int x;
        int y;
        Node prev;
        Node next;

        Node(char symbol, int x, int y) {
            this.symbol = symbol;
            this.x = x;
            this.y = y;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public void DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(char symbol, int x, int y) {
        Node newNode = new Node(symbol, x, y);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void remove(char symbol) {
        if (isEmpty()) {
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.symbol == symbol) {
                if (current == head) {
                    head = current.next;
                    tail.next = head;
                    head.prev = tail;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = head;
                    head.prev = tail;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
            if (current == head) {
                break;
            }
        }
    }

    public void printList() {
        if (isEmpty()) {
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println("Symbol: " + current.symbol + ", Position: (" + current.x + ", " + current.y + ")");
            current = current.next;
            if (current == head) {
                break;
            }
        }
    }
}
