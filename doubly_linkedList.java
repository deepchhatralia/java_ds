import java.util.*;

class DoublyLL {
    public Node head = null;
    public Node tail = null;
    public int size = 0;
    
    class Node {
        Node prev = null;
        int data;
        Node next = null;
        Node(int data){
            size++;
            this.data = data;
        }
    }
    
    public boolean isEmpty(){
        if(head == null) System.out.println("Linked list is empty");
        return head != null ? false : true;
    } 
    
    public void push(int data, boolean atFirst, int position){
        Node newNode = new Node(data);
        newNode.prev = tail;
        System.out.println("Added");
        
        if(position == 1){
            atFirst = true;
            position = -1;
        }
        
        if(position > 0 && position <= size) {
            Node index = head;
            int count = 1;
            
            while(count != position){
                index = index.next;
                count++;
            }
            newNode.prev = index.prev;
            index.prev.next = newNode;
            index.prev = newNode;
            newNode.next = index;
            printLL();
            return;
        }

        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        
        if(atFirst){
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }
        
        tail.next = newNode;
        tail = newNode;
    }
    
    public int pop(boolean first){
        if(size == 1){
            int temp = head.data;
            head = null;
            tail = null;
            size--;
            return temp;
        }
        if(first){
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        printLL();
        return temp.data;
    }
    
    public void update(int original, int updated){
        Node index = head;
        while(index != null && index.data != original){
            index = index.next;
        }
        if(index == null){
            System.out.println("Value not found");
            return;
        }
        index.data = updated;
        System.out.println("Updated");
        printLL();
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
        DoublyLL ll = new DoublyLL();
        boolean flag = true;
        int choice;
        Scanner sc = new Scanner(System.in);
        
        while(flag){
            System.out.println("-----------------------------");
            System.out.println("1) Push");
            System.out.println("2) Push at first");
            System.out.println("3) Pop");
            System.out.println("4) Pop from first");
            System.out.println("5) Update");
            System.out.println("6) Print");
            System.out.println("7) Exit");
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
                    if(ll.isEmpty())
                        break;
                    System.out.println("Popped : " + ll.pop(false));
                    break;
                case 4:
                    if(ll.isEmpty())
                        break;
                    System.out.println("Popped : " + ll.pop(true));
                    break;
                case 5:
                    if(ll.isEmpty())
                        break;
                    System.out.println("Enter original value : ");
                    int original = sc.nextInt();
                    System.out.println("Enter updated value : ");
                    ll.update(original,sc.nextInt());
                    break;
                case 6:
                    ll.printLL();
                    break;
                case 7:
                    System.out.println("Goodbye");
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }
        
    }
}