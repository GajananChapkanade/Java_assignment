package program;

class Node1 {
    int data;
    Node1 next, prev;
    
    Node1(int data) { this.data = data; }
}

class DoublyLinkedList {
    Node1 head;

    
    public void insert(int data) {
        Node1 node = new Node1(data); 
        if (head == null) {
            head = node;
        } else {
            Node1 last = head;
            while (last.next != null) last = last.next;
            last.next = node;
            node.prev = last;
        }
    }

   
    public void insertAt(int index, int data) {
        Node1 node = new Node1(data);
        if (index == 0) {
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
        } else {
            Node1 temp = head;
            for (int i = 0; i < index - 1; i++) temp = temp.next;
            node.next = temp.next;
            if (temp.next != null) temp.next.prev = node;
            temp.next = node;
            node.prev = temp;
        }
    }

   
    public void deleteAt(int index) {
        if (head == null) return;
        Node1 temp = head;
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
        } else {
            for (int i = 0; i < index; i++) temp = temp.next;
            if (temp.prev != null) temp.prev.next = temp.next;
            if (temp.next != null) temp.next.prev = temp.prev;
        }
    }

    
    public void displayForward() {
        for (Node1 n = head; n != null; n = n.next) System.out.print(n.data + " -> ");
        System.out.println("null");
    }

   
    public void displayReverse() {
        Node1 n = head;
        while (n != null && n.next != null) n = n.next;
        for (; n != null; n = n.prev) System.out.print(n.data + " -> ");
        System.out.println("null");
    }
}

public class DoublyLinkList {  
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.displayForward();  
        list.insertAt(1, 15);
        list.displayForward();  
        list.deleteAt(2);
        list.displayForward();  
        list.displayReverse();  
    }
}
