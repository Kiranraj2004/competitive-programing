import java.awt.*;
import java.util.*;

public class Dsa {

    public static void main (String[] args) throws java.lang.Exception{
            Scanner in=new Scanner(System.in);
            int t=in.nextInt();
            while(t-->0){
                solve(in);
            }

    }

    private static int solve(Scanner in) {
        int n=in.nextInt();
        int x=in.nextInt();
        boolean temp[]=new boolean[1000000];
        ArrayList<Integer>prime=helper(temp);

        int []count=new int[1000000];
        for(int i:prime){
            for(int j=i;j<count.length;j+=i){
                count[j]++;
            }
        }
        int ans=0;
        for(int i=n;i<x;i++) {
            ans += count[i];
        }

        return ans;
    }

    private static   ArrayList<Integer> helper(boolean[] temp) {
        ArrayList<Integer>an=new ArrayList<>();
        for(int i=2;i<temp.length;i++){
            if(temp[i]==false){
                an.add(i);
                temp[i]=true;
            }
            if(temp[i])continue;
            for(int j=i;j<=temp.length;j+=i){
                temp[j]=true;
            }
        }
        return an;
    }

    public ArrayList<String> getLongestSubsequence(String[] words, int[] groups) {
        ArrayList<String>ans=new ArrayList<>();
        ans.add(words[0]);
        int prev=groups[0];
        int i=1;
        while(i<groups.length){
            if(prev!=groups[i]){
                ans.add(words[i]);
                prev=groups[i];
            }
            i++;
        }
        return ans;
    }

    public long sumOfLargestPrimes(String s) {
        Set<Long>number=new HashSet<>();
        for(int i=0;i<s.length();i++){
            long sum=0;
            for(int j=i;j<s.length();j++){
                sum*=10;
                sum+=s.charAt(j)-'0';
                if(isprime(sum)){
                    number.add(sum);
                }
            }
        }
        ArrayList<Long>prime=new ArrayList<>(number);
        prime.sort((x,y)-> (int) (y-x));
        long ans=0;
        for(int i=0;i<3&&i<prime.size();i++){
            ans+=prime.get(i);
        }

        return ans;


    }

    private boolean isprime(long sum) {
        if(sum<2)return false;
        for(int i=2;i*i<=sum;i++){
            if(sum%i==0)return false;

        }
        return true;
    }


}
