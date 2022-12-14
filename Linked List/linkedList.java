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
    
    public boolean isEmpty(){
        if(head == null) System.out.println("Linked list is empty");
        return head != null ? false : true;
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
    
    public int pop(boolean first){
        if(size == 1){
            int temp = head.data;
            head = null;
            size--;
            return temp;
        }
        if(first){
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        Node index = head;
        Node nextIndex = head.next;
        while(nextIndex.next != null){
            index = nextIndex;
            nextIndex = nextIndex.next;
        }
        index.next = null;
        size--;
        printLL();
        return nextIndex.data;
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
            System.out.println("6) Update");
            System.out.println("7) Print");
            System.out.println("8) Exit");
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
                        if(ll.isEmpty())
                            break;
                        System.out.println("Invalid index");
                        break;
                    }
                    System.out.println("Enter data : ");
                    ll.push(sc.nextInt(),false,index);
                    break;
                case 4:
                    if(ll.isEmpty())
                        break;
                    System.out.println("Popped : " + ll.pop(false));
                    break;
                case 5:
                    if(ll.isEmpty())
                        break;
                    System.out.println("Popped : " + ll.pop(true));
                    break;
                case 6:
                    if(ll.isEmpty())
                        break;
                    System.out.println("Enter original value : ");
                    int original = sc.nextInt();
                    System.out.println("Enter updated value : ");
                    ll.update(original,sc.nextInt());
                    break;
                case 7:
                    ll.printLL();
                    break;
                case 8:
                    System.out.println("Goodbye");
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }
        
    }
}