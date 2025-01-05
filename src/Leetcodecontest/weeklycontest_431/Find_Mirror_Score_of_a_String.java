package Leetcodecontest.weeklycontest_431;

import java.util.ArrayList;
import java.util.HashMap;

public class Find_Mirror_Score_of_a_String {
    public static void main(String[] args) {
        String s="aczzx";
        System.out.println(calculateScore(s));
    }

    public static long calculateScore(String s) {
        HashMap<Character, ArrayList<Integer>>map=new HashMap<>();
        long score=0;
        ArrayList<Integer>temp=new ArrayList<>();
        temp.add(0);
        map.put(s.charAt(0),temp);
        for (int i = 1; i <s.length() ; i++) {
            int r=(int)s.charAt(i)-'a';
            char reverse=(char)((25-r)+'a');
            if(map.containsKey(reverse)){
                temp=map.get(reverse);
                score+=(i-temp.get(temp.size()-1));
                temp.remove(temp.size()-1);
                if(temp.isEmpty()){
                    map.remove(reverse);
                }
            }
            else{

                if(map.containsKey(s.charAt(i))){
                    temp=map.get(s.charAt(i));
                }
                else{
                    temp=new ArrayList<>();
                }
                    temp.add(i);
                    map.put(s.charAt(i),temp);

            }
        }
        return score;

    }
}
