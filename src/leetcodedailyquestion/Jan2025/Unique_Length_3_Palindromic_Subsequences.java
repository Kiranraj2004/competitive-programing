package leetcodedailyquestion.Jan2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Unique_Length_3_Palindromic_Subsequences {
    public static void main(String[] args) {
        String s="aabca";
        System.out.println(countPalindromicSubsequence(s));

    }
    public static int countPalindromicSubsequence(String s) {
        HashMap<Character, ArrayList<Integer>>map=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char a=s.charAt(i);
            if(map.containsKey(a)){
                ArrayList<Integer>temp=map.get(a);
                if(temp.size()==1)temp.add(i);
                else temp.set(1,i);
                map.put(a,temp);
            }
            else{
                ArrayList<Integer>temp=new ArrayList<>();
                temp.add(i);
                map.put(a,temp);
            }
        }
        int count=0;
        for(char a:map.keySet()){
            ArrayList<Integer>temp=map.get(a);
            if(temp.size()==1||temp.get(1)-temp.get(0)<=1)continue;
            else{
                int start=temp.get(0);
                int end=temp.get(1);
                HashSet<Character>m=new HashSet<>();
                for (int i = start+1; i <end ; i++) {
                    m.add(s.charAt(i));
                }
                count+=m.size();
            }
        }
        return count;
    }
}
