public class Zadanie12 {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class CircularLinkedList {
        Node head;

        public void insert(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                head.next = head; // Устанавливаем указатель на самого себя, чтобы создать цикличность списка
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
            }
            System.out.println(data + " вставлен в список.");
        }

        public void display() {
            Node current = head;

            if (head == null) {
                System.out.println("Список пуст.");
            } else {
                System.out.print("Список: ");
                do {
                    System.out.print(current.data + " ");
                    current = current.next;
                } while (current != head);
                System.out.println();
            }
        }

        public void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;

            do {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            } while (current != head);

            head.next = prev;
            head = prev;

            System.out.println("Список был обращен.");
        }
    }

    public class Main {
        public void main(String[] args) {
            CircularLinkedList list = new CircularLinkedList();

            list.insert(5);
            list.insert(10);
            list.insert(15);

            list.display();

            list.reverse();

            list.display();
        }
    }
}
