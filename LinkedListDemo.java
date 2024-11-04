package program;

class Node {
    int data;
    Node next; // Each node points to the next node in the list
}

class LinkedList {
    Node head; // Head points to the first node in the list

    // Insert at end
    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node; // If list is empty, head points to the new node
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next; // Traverse to the last node
            }
            n.next = node; // Link the last node to the new node
        }
    }

    // Insert at start
    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head; // Point new node to the current head
        head = node; // Update head to new node
    }

    // Insert at a specific position
    public void insertAt(int index, int data) {
        Node node = new Node();
        node.data = data;

        if (index == 0) {
            insertAtStart(data); // If index is 0, insert at the start
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next; // Traverse to the (index-1)th node
            }
            node.next = n.next; // Point new node to the next node in sequence
            n.next = node; // Link (index-1)th node to new node
        }
    }

    // Delete at a specific position
    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next; // If deleting the head, move head to the next node
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next; // Traverse to the (index-1)th node
            }
            Node n1 = n.next; // Node to be deleted
            n.next = n1.next; // Bypass the node to be deleted
            n1 = null; // Optional: help garbage collection
        }
    }

    // Display the list
    public void show() {
        Node node = head;
        while (node != null) { // Traverse the list and print each node's data
            System.out.println(node.data);
            node = node.next;
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        list.show(); // Output: 18 45 12
        list.insertAtStart(55);
        list.show(); // Output: 55 18 45 12
        list.insertAt(2, 95);
        list.show(); // Output: 55 18 95 45 12
        list.deleteAt(2);
        list.show(); // Output: 55 18 45 12
    }
}
