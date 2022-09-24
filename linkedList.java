import java.util.*;

class LL {
    public Node head = null;
    public int size = 0;
    
    class Node {
        int data;
        Node next;
        Node(int data){
            size++;
            this.data = data;
            this.next = null;
        }
    }
    
    public void push(int data, boolean atFirst, int position){
        // if(position > 0 && position <= size) 
        Node newNode = new Node(data);
        System.out.println("Added");
        if(head == null){
            head = newNode;
            return;
        }
        if(atFirst){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node index = head;
        while(index.next != null){
            index = index.next;
        }
        index.next = newNode;
    }
    
    public void printLL(){
        if(head == null) System.out.println("Linked list is empty");
        
        Node index = head;
        while(index != null){
            System.out.print(index.data + "->");
            index = index.next;
        }
        System.out.println("NULL");
    }
    
    public static void main(String args[]){
        LL ll = new LL();
        boolean flag = true;
        int choice;
        Scanner sc = new Scanner(System.in);
        
        while(flag){
            System.out.println("-----------------------------");
            System.out.println("1) Push");
            System.out.println("2) Push at first");
            System.out.println("3) Push at specific index");
            System.out.println("4) Pop");
            System.out.println("5) Pop from first");
            System.out.println("6) Pop specific index");
            System.out.println("7) Update");
            System.out.println("8) Print");
            System.out.println("9) Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    System.out.print("Enter data : ");
                    ll.push(sc.nextInt(),false,-1);
                    break;
                case 2:
                    System.out.println("Enter data : ");
                    ll.push(sc.nextInt(),true,-1);
                    break;
                case 8:
                    ll.printLL();
                    break;
                case 9:
                    System.out.println("Goodbye");
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }
        
    }
}