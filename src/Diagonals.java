import java.util.Scanner;

public class Diagonals {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int x =input.nextInt();
        for (int i = 1; i <=x ; i++) {
            int n=input.nextInt();
            int k=input.nextInt();
            int ans=findmindiagonal(n,k);
            System.out.println(ans);
        }
    }

    private static int findmindiagonal(int n, int k) {
        if(k==0){
            return 0;
        }
        int count=0;
        k-=n;
        count++;
        for (int i = n-1; i >0&&k>0 ; i--) {
            k-=i;
            count++;
            if(k>0){
                k-=i;
                count++;
            }
        }

        return count;
    }
}
