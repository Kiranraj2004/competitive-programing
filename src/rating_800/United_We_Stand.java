package rating_800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class United_We_Stand {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            solve(in);
        }
    }
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(workers);
        Arrays.sort(tasks);
        int n=workers.length;
        int count=0;
        int j=0;
        for(int i=0;i<n;i++){
            if(tasks[i]<=workers[j]){
                count++;
                j++;
            }
            else{
                if(pills>0&&(workers[j]+strength)>=tasks[i]){
                    count++;
                    pills--;
                    j++;
                }
            }
        }
        return count;


    }

    private static void solve(Scanner in) {
        int n=in.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=in.nextInt();
        Arrays.sort(arr);
        if(arr[0]==arr[n-1]){
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer>l2=new ArrayList<>();
        int first=arr[0];
        for(int i:arr){
            if(i==first){
                l1.add(i);
            }
            else{
                l2.add(i);
            }
        }
        System.out.println(l1.size()+" "+l2.size());
        for(int i:l1){
            System.out.print(i+" ");
        }
        System.out.println();
        Collections.sort(l2);
        for(int i:l2){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
