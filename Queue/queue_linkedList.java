import java.util.*;

class Queue {
    public int size = 0;
    public Node rear = null;
    
    class Node {
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
            size++;
        }
    }
    
    public void add(int data){
        Node newNode = new Node(data);
        if(rear == null){
            rear = newNode;
            return;
        }
        Node index = rear;
        while(index.next != null){
            index = index.next;
        }
        index.next = newNode;
    }
    
    public void remove(){
        if(rear == null){
            System.out.println("Queue is empty");
            return;
        }
        rear = rear.next;
        size--;
        System.out.println("Removed");
    }
    
    public void print(){
        if(rear == null){
            System.out.println("Queue is empty");
            return;
        }
        Node index = rear;
        while(index != null){
            System.out.print(index.data + "->");
            index = index.next;
        }
        System.out.println("NULL");
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        boolean flag = true;
        int choice;
        Scanner sc = new Scanner(System.in);
        
        while(flag){
            System.out.println("--------------------");
            System.out.println("1) Add");
            System.out.println("2) Remove");
            System.out.println("3) Print");
            System.out.println("4) Size");
            System.out.println("5) Exit");
            System.out.println("--------------------");
            
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Enter data : ");
                    q.add(sc.nextInt());
                    break;
                case 2:
                    q.remove();
                    break;
                case 3:
                    q.print();
                    break;
                case 4:
                    System.out.println("Size : " + q.size);
                    break;
                case 5:
                    System.out.println("GOODBYE");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
;            }
        }
    }
}