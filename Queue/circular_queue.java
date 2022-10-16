import java.util.*;

class CircularQueue {
    int size;
    int front = -1, rear = -1;
    
    public int arr[];
    
    CircularQueue(int size){
        this.size = size;
        arr = new int[this.size];
    }
    
    public void enqueue(int data){
        if(front == -1 && rear == -1){
            front = rear = 0;
            arr[rear] = data;
        }else if((front == 0 && rear == this.size-1) || rear + 1 == front){
            System.out.println("Overflow");
        }else{
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
    }
    
    public void print(){
        if(front == -1 && rear == -1){
            System.out.println("Underflow");
            return;
        }
        int i = front;
        while(i != rear){
            System.out.print(arr[i] + "->");
            i = (i + 1) % size;
        }
        System.out.println(arr[i] + "->NULL");
    }
    
    public void dequeue(){
        if(front == -1){
            System.out.println("Underflow");
            return;
        }
        
        System.out.println("Removed : " + arr[front]);
        front = (front + 1) % size;
        if(front == (rear + 1) % size){
            front = rear = -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue cq = new CircularQueue(5);
        boolean flag = true;
        int choice;
        
        while(flag){
            System.out.println("--------------------");
            System.out.println("1) Add");
            System.out.println("2) Remove");
            System.out.println("3) Print");
            System.out.println("4) Size");
            System.out.println("5) Exit");
            System.out.println("--------------------");
            
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    System.out.print("Enter data : ");
                    cq.enqueue(sc.nextInt());
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.print();
                    break;
                case 4:
                    System.out.println("Size : " + cq.size);
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