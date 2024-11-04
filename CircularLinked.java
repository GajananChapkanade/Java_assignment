package program;

class Node2 {
    int data;
    Node2 next, prev;

    Node2(int data) { this.data = data; }
}

class CircularLinkedList {
    Node2 head;

   
    public void insert(int data) {
        Node2 node = new Node2(data);
        if (head == null) {
            head = node;
            head.next = head; 
            head.prev = head; 
        } else {
            Node2 last = head.prev; 
            last.next = node;
            node.prev = last;
            node.next = head; 
            head.prev = node; 
        }
    }

    
    public void insertAt(int index, int data) {
        Node2 node = new Node2(data);
        if (index == 0) {
            if (head == null) {
                head = node;
                head.next = head; 
                head.prev = head; 
            } else {
                Node2 last = head.prev; 
                node.next = head; 
                node.prev = last; 
                last.next = node; 
                head.prev = node; 
                head = node; 
            }
        } else {
            Node2 temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
                if (temp == head) break; 
            }
            node.prev = temp.prev; 
            node.next = temp; 
            temp.prev.next = node; 
            temp.prev = node; 
        }
    }

  
    public void deleteAt(int index) {
        if (head == null) return;

        Node2 temp = head;
        if (index == 0) {
            if (temp.next == head) {
                head = null; 
            } else {
                Node2 last = head.prev; 
                head = head.next; 
                last.next = head; 
                head.prev = last; 
            }
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
                if (temp == head) return; 
            }
            temp.prev.next = temp.next; 
            if (temp.next != head) {
                temp.next.prev = temp.prev; 
            }
        }
    }

    
    public void displayForward() {
        if (head == null) return;
        Node2 n = head;
        do {
            System.out.print(n.data + " <-> ");
            n = n.next;
        } while (n != head);
        System.out.println("(head)");
    }

    
    public void displayReverse() {
        if (head == null) return;
        Node2 n = head.prev; 
        do {
            System.out.print(n.data + " <-> ");
            n = n.prev;
        } while (n != head.prev); 
        System.out.println("(tail)");
    }
}

public class CircularLinked {  
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
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
