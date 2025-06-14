package Leetcodecontest.biweekly_contest_147;
import java.util.*;
public class TaskManager {
    public static void main(String[] args) {
        List<List<Integer>>temp=new ArrayList<>();
        ArrayList<Integer>a=new ArrayList<>();
        a.add(2);a.add(102);a.add(20);
        TaskManager obj=new TaskManager(temp);
        obj.add(2,102,20);
        obj.add(3,104,10);
        obj.edit(102,8);;
        System.out.println(obj.execTop());



    }
    static class pair{
        int userid;
        int taskid;
        int priority;
        pair(int u,int t,int p){
            userid=u;
            taskid=t;
            priority=p;
        }
    }
    TreeMap<pair,Integer>q;
    Map<Integer,pair>tablemap;
    public TaskManager(List<List<Integer>> tasks) {
        q=new TreeMap<>((x,y)->{
            int valuecomparison=Integer.compare(y.priority,x.priority);
            if(valuecomparison==0){
                return Integer.compare(y.taskid,x.taskid);
            }
            return valuecomparison;
        });
        tablemap=new HashMap<>();

        for (List<Integer> temp : tasks) {
            pair newpair=new pair(temp.get(0),temp.get(1),temp.get(2));
           q.put(newpair, temp.get(0));
           tablemap.put(temp.get(1),newpair);
        }
    }

    public void add(int userId, int taskId, int priority) {
        pair newpair=new pair(userId,taskId,priority);
        q.put(newpair, userId);
        tablemap.put(taskId,newpair);
    }

    public void edit(int taskId, int newPriority) {
        pair task=tablemap.get(taskId);
        q.remove(task);
        task.priority=newPriority;
        q.put(task,task.userid);
    }

    public void rmv(int taskId) {
        pair task=tablemap.get(taskId);
        q.remove(task);
        tablemap.remove(task.taskid);
    }

    public int execTop() {
        if(q.isEmpty())return -1;
       pair task=q.firstKey();
       q.remove(task);
       tablemap.remove(task.taskid);
       return task.userid;
    }

}
