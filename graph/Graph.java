package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph { //无向图

    private int v;
    private LinkedList<Integer> adj[];

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEage(0,1);
        graph.addEage(1,4);
        graph.addEage(1,2);
        graph.addEage(0,3);
        graph.addEage(3,4);
        graph.addEage(4,5);
        graph.addEage(2,5);
        graph.addEage(4,6);
        graph.addEage(5,7);
        graph.addEage(6,7);

        for(int i=0; i< graph.adj.length; i++) {
            System.out.println(i+",List:"+graph.adj[i]);
        }
        graph.bfs(0,6);

        graph.dfs(0,6);
    }
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEage(int s, int t) {// 无向图一条边存两次

        adj[s].add(t);
        adj[t].add(s);

    }

    //从 s 到 t 的最短路径。
    public void bfs(int s, int t) {

        if(s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int[] prev = new int[v];
        for(int i=0; i<v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            System.out.println("queue:"+queue);
            int w = queue.poll();

            for(int i=0; i<adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if(!visited[q]) {
                    prev[q] = w;
                    printPrev(prev);
                    if(q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }
    public  void print(int [] prev, int s, int t) {// 递归打印 s->t 的路径
        if(prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    private void printPrev(int[] prev) {
        for(int i=0; i< prev.length; i++){
            System.out.print(prev[i]+",");
        }
        System.out.println();
    }

    boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

}
