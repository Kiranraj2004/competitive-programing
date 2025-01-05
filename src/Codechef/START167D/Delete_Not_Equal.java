package Codechef.START167D;
import java.util.*;

public class Delete_Not_Equal {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t;i++){
            int n=in.nextInt();
            StringBuffer s=new StringBuffer();

                s.append(in.next());

            getans(s);
        }

    }
    private static void getans(StringBuffer s) {
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i)!=s.charAt(i-1)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(s.length());
    }
}
