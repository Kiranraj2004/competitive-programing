package leetcodedailyquestion.Jan2025;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Construct_K_Palindrome_Strings {
    public static void main(String[] args) {
        String s="true";
        System.out.println(canConstruct(s,4));

    }

//    my approach
    public static  boolean canConstruct(String s, int k) {
        if(s.length()<=k)return  true;
        HashMap<Character,Integer>map=new HashMap<>();
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if(map.size()<=k)return true;
        PriorityQueue<Integer>q=new PriorityQueue<>((x,y)->y-x);
        q.addAll(map.values());
        int []arr=new int[k];
        while(!q.isEmpty()){
            for (int i = 0; i <k&&!q.isEmpty() ; i++) {
                int count=q.poll();
                if(arr[i]%2==0){
                    if(count>=2){
                        arr[i]+=2;
                        count-=2;
                    }else{
                        arr[i]+=1;
                        count-=1;
                    }
                    if(count>0)q.add(count);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static  boolean canConstruct1(String s, int k) {
        if(s.length()<k)return  false;
        HashMap<Character,Integer>map=new HashMap<>();
        int []temp=new int[26];
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
            int index=(int)i-'a';
            temp[index]++;
        }
        if(map.size()==k||s.length()==k)return true;
        int count=0;
       for(int i:map.values()){
           if((i&1)==1){
               count++;
           }
       }

       return count<=k;
    }


}
