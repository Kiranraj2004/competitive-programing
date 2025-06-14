package leetcodedailyquestion.May2025;

import jdk.jshell.spi.SPIResolutionException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Resulting_String_After_Adjacent_Removals {
    public static void main(String[] args) {

    }
    public String resultingString(String s) {
        Stack<Character>stk=new Stack<>();
        stk.add(s.charAt(0));
        int n=s.length();
        for(int i=1;i<n;i++){
            char present=s.charAt(i);
            if(stk.isEmpty()){
               stk.add(present);
            }
            if(present=='a'&&stk.peek()=='z'){
                stk.pop();
                continue;

            }
             if(present=='z'&&stk.peek()=='a'){
                stk.pop();
                continue;
            }
             int prev=stk.peek()-'a';
             int currnumber=present-'a';
             if(Math.abs(prev-currnumber)==1){
                 stk.pop();
                 continue;
             }
             stk.push(present);
        }
        StringBuffer ans=new StringBuffer();
        for(char i:stk){
            ans.append(i);
        }
        return ans.toString();
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int distnode1[]=new int[n];
        Arrays.fill(distnode1,Integer.MAX_VALUE);
        int distnode2[]=new int[n];
        Arrays.fill(distnode2,Integer.MAX_VALUE);
        bfs(edges,node1,distnode1);
        bfs(edges,node1,distnode1);
        int ansnode = -1;
        int ansdist=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(distnode1[i]==-1||distnode2[i]==-1){
                continue;
            }
            int max=Math.max(distnode1[i],distnode2[i]);
            if(ansdist>max){
                ansdist=max;
                ansnode=i;
            }

        }
        return ansnode;
    }

    private void dfs(int[]edge,int node,int[]dist){
        int presntdist=dist[node];
        int nextnode=edge[node];
        if(dist[nextnode]>presntdist+1){
            dist[nextnode]= presntdist+1;
            dfs(edge,nextnode,edge);
        }
    }

    private void bfs(int[] edges, int node1, int[] dist) {
        Queue<Integer>q=new LinkedList<>();
        q.add(node1);
        dist[node1]=0;
        while(!q.isEmpty()){
            int node=q.poll();
            int distance=dist[node];
            int next=edges[node];
            if(dist[next]>distance+1){
                dist[next]=distance+1;
                q.add(next);
            }
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
    }
}
