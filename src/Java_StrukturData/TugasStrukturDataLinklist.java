package Java_StrukturData;
  
class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data; //
        this.next = null; //
    }
}

class LinkedList {
    Node first;
    
    public LinkedList() {
        first = null;
    }
    
    public void insert(int data) {
        Node new_node = new Node(data);
        
        if (first == null) {
            first = new_node;
            return;
        }
        
        if (data < first.data) {
            new_node.next = first;
            first = new_node;
            return;
        }
        
        Node current_node = first;
        while (current_node.next != null && current_node.next.data < data) {
            current_node = current_node.next;
        }
        
        new_node.next = current_node.next;
        current_node.next = new_node;
    }
    
    public void display() {
        Node current_node = first;
        while (current_node != null) {
            System.out.print(current_node.data + " ");
            current_node = current_node.next;
        }
        System.out.println();
    }
}

// yang ini kalo diimplementasiin ke bapake. aku ngga tau ini bener apa ngga
public class TugasStrukturDataLinklist {
    public static void main(String[] args) {
        LinkedList my_list = new LinkedList();
        my_list.insert(3);
        my_list.insert(5);
        my_list.insert(10);
        my_list.display();  // output: 3 5 10
        
        my_list.insert(7);
        my_list.display();  // output: 3 5 7 10
        
        my_list.insert(2);
        my_list.display();  // output: 2 3 5 7 10
        
        my_list.insert(15);
        my_list.display();  // output: 2 3 5 7 10 15
    }
}