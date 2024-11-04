package program;

class Node {
    int data;
    Node next; 
}

class LinkedList {
    Node head; 

  
    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node; 
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next; 
            }
            n.next = node; 
        }
    }

   
    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head; 
        head = node; 
    }

   
    public void insertAt(int index, int data) {
        Node node = new Node();
        node.data = data;

        if (index == 0) {
            insertAtStart(data); 
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next; 
            }
            node.next = n.next; 
            n.next = node; 
        }
    }


    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next; 
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next; 
            }
            Node n1 = n.next; 
            n.next = n1.next; 
            n1 = null; 
        }
    }

 
    public void show() {
        Node node = head;
        while (node != null) { 
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
