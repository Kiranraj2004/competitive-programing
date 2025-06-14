package leetcodedailyquestion.july2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lexicographically_Smallest_Equivalent_String {
    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("abc","cde","eed"));

    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        ArrayList<ArrayList<Character>>adj=new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        int n=s1.length();
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            adj.get(c1-'a').add(c2);
            adj.get(c2-'a').add(c1);
        }
        char []ans=new char[26];
        boolean []v=new boolean[26];
        for(int i=0;i<26;i++){
            if(!v[i]){
                if(adj.get(i).isEmpty()){
                    ans[i]=(char)(i+(int)'a');
                }
                else{
                    bfs(adj,v,ans,i);
                }
            }
        }
        StringBuffer a=new StringBuffer();
        for(char i:baseStr.toCharArray()){
            a.append(ans[i-'a']);
        }
        return a.toString();

    }

    private static void bfs(ArrayList<ArrayList<Character>> adj, boolean[] v, char[] ans, int n) {
        Queue<Integer>q=new LinkedList<>();
        int min=n;
        q.add(n);
        ArrayList<Integer>a=new ArrayList<>();
        v[n]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            a.add(node);
            min=Math.min(min,node);
            for(char i:adj.get(node)){
                if(!v[i-'a']){
                    q.add((int)i-'a');
                    v[i-'a']=true;
                }
            }
        }
        char f=(char)(min+'a');
        for(int index:a){
            ans[index]=f;
        }
    }
}
