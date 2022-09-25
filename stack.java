import java.util.*;

// Stack using linked list
class Stack {
    public Node head;
    public Node top;
    public int size = 0;
    
    class Node {
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }
    
    public void push(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            top = newNode;
            size++;
            return;
        }
        
        top.next = newNode;
        top = newNode;
        size++;
    }
    
    public void pop(){
        if(top == null){
            System.out.println("Stack is empty");
            return;
        }
        if(size == 1){
            int temp = head.data;
            head = null;
            top = null;
            System.out.println("Pop : " + temp);
            return;
        }
        Node index = head;
        while(index.next.next != null){
            index = index.next;
        }
        int temp = index.next.data;
        index.next = null;
        top = index;
        size--;
        System.out.println("Pop : " + temp);
    }
    
    public int peek(){
        if(top == null) return 0;
        
        return top.data;
    }
    
    public void printStack(){
        if(head == null){
            System.out.println("Stack is empty");
            return;
        }
        Node index = head;
        while(index != null){
            System.out.print(index.data + "->");
            index = index.next;
        }
        System.out.println("NULL");
    }
    
    public static void main(String args[]){
        Stack st = new Stack();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag = true;
        
        while(flag){
            System.out.println("-----------------------------");
            System.out.println("1) Push");
            System.out.println("2) Pop");
            System.out.println("3) Peek");
            System.out.println("4) Print");
            System.out.println("5) Size");
            System.out.println("6) Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Enter data : ");
                    st.push(sc.nextInt());
                    break;
                case 2:
                    st.pop();
                    break;
                case 3:
                    System.out.println("Peek : " + st.peek());
                    break;
                case 4:
                    st.printStack();
                    break;
                case 5:
                    System.out.println("Size of stack : " + st.size);
                    break;
                case 6:
                    System.out.println("GOODBYE");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choide");
            }
        }
    }
}