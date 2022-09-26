import java.util.*;

class Queue {
    public static int size = 100;
    public static int count = -1;
    public static int arr[] = new int[size];
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int choice;
        // Queue q = new Queue();
        
        
        while(flag){
            System.out.println("--------------------");
            System.out.println("1) Add");
            System.out.println("2) Remove");
            System.out.println("3) Print");
            // System.out.println("4) Size");
            System.out.println("4) Exit");
            System.out.println("--------------------");
            
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    if(count < size-1){
                        System.out.println("Enter data : ");
                        arr[++count] = sc.nextInt();
                    }else System.out.println("Queue is full");
                    break;
                case 2:
                    if(count >= 0){
                        for(int i = 1 ; i <= count ; i++){
                            arr[i-1] = arr[i];
                        }
                        count--;
                    }else System.out.println("Queue is empty");
                    break;
                case 3:
                    if(count >= 0){
                        for(int i = 0 ; i <= count ; i++){
                            System.out.print(arr[i] + "->");
                        }
                        System.out.println("NULL");
                    }else System.out.println("Queue is empty");
                    break;
                // case 4:
                //     System.out.println("Size : " + count+1);
                //     break;
                case 4:
                    System.out.println("GOODBYE");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
;            }
        }
    }
}