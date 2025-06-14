package rating_800;

import java.util.Scanner;

public class Jagged_Swaps {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
        int []arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=in.nextInt();
            }
            if(arr[0]==1){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
