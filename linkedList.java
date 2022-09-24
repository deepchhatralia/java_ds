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
        Node newNode = new Node(data);
        System.out.println("Added");
        
        if(position == 1){
            atFirst = true;
            position = -1;
        }
        
        if(position > 0 && position <= size) {
            Node index = head;
            Node nextIndex = head.next;
            int count = 1;
            
            while(count != position-1){
                index = nextIndex;
                nextIndex = nextIndex.next;
                count++;
            }
            newNode.next = index.next;
            index.next = newNode;
            this.printLL();
            return;
        }

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
                case 3:
                    System.out.println("Enter index where you want to add : ");
                    int index = sc.nextInt();
                    if(index > ll.size){
                        if(ll.head == null){
                            System.out.println("Linked list is empty");
                            break;
                        }
                        System.out.println("Invalid index");
                        break;
                    }
                    System.out.println("Enter data : ");
                    ll.push(sc.nextInt(),false,index);
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