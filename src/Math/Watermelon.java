package Math;

import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int w= input.nextInt();
        if ((w&1)==1) System.out.println("No");
        else{
            System.out.println("YES");
        }
    }
}
