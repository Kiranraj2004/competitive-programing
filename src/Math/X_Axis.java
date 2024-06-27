package Math;

import java.util.Scanner;

public class X_Axis {
    public static void main(String[] args) { Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        for (int i = 1; i <=n ; i++) {
            int x1= input.nextInt();
            int x2= input.nextInt();
            int x3= input.nextInt();
            int max=Math.max(x1,Math.max(x2,x3));
            int min=Math.min(x1,Math.min(x2,x3));
            System.out.println(max-min);
        }
    }
}
