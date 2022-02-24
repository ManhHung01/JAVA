package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mạnh Hưng
 */
public class Main {
    public static String PrintArr(int[] arr,int n) {
        String str = "[";
        for (int i = 0; i < n; i++) {
            str = str + arr[i];
            if (i < n - 1) {
                str = str +", ";
            }
        }
        str = str + "]";
        return str;
    }
     public static int CheckInt(String Mess){
        Scanner sc=new Scanner(System.in);
    int num;
    do{
        System.out.print(Mess);
        try {
            num=Integer.parseInt(sc.nextLine());
            if(num>0){
                break;
            }
            System.out.println("Enter number of array >0");
        } catch (Exception e) {
            System.out.println("Invalid input, plz input again");
        }
    }while(true);
    return num;
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Random rd= new Random();
        Scanner sc= new Scanner(System.in);
        int n = CheckInt("Enter number of array: ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=rd.nextInt(n);
        }
        System.out.println("Unsorted array: "+PrintArr(arr,n));
        
        int temp; 
        for(int i=0; i < n; i++){          
            for(int j=1; j < n-i; j++){    
                if(arr[j-1] > arr[j]){  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;                      
                }                             
            }           
        }       
        System.out.println("Sorted array: "+PrintArr(arr,n));
    }   
}
/*  
3 7 4 9 2
3 7 4 9 2
3 4 7 9 2
3 4 7 9 2
3 4 7 2 9

3 4 7 2 9
3 4 7 2 9
3 4 2 7 9
3 4 2 7 9
3 2 4 7 9
2 3 4 7 9








 
   


*/