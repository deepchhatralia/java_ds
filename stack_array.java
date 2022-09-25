import java.util.*;

// Stack using array
class Stack {
    int size = 10, count = -1;
    int arr[] = new int[size];
    
    public void push(int data){
        
        if(count == size-1){
            System.out.println("Stack overflow");
            return;
        }
        arr[++count] = data;
        System.out.println("Added");
        System.out.println(count);
    }
    
    public void pop(){
        if(count < 0){
            System.out.println("Stack underflow");
            return;
        }
        int temp = arr[count];
        arr[count--] = 0;
        System.out.println("Pop : " + temp);
    }
    
    public int peek(){
        if(count < 0) return 0;
        
        return arr[count];
    }
    
    public void printStack(){
        if(count < 0){
            System.out.println("Stack underflow");
            return;
        }
        for(int i = 0 ; i <= count ; i++){
            System.out.print(arr[i] + "->");
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