package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphNew { // 有向有权图的邻接表表示
    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    public GraphNew(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        GraphNew graphNew = new GraphNew(6);
        graphNew.addEdge(0,1,10);
        graphNew.addEdge(0,4, 15);
        graphNew.addEdge(1,2,15);
        graphNew.addEdge(1,3,2);
        graphNew.addEdge(2,5,5);
        graphNew.addEdge(3,2,1);
        graphNew.addEdge(3,5,12);
        graphNew.addEdge(4,5,10);

        graphNew.dijkstra(0,5);
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重
        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }
    // 下面这个类是为了 dijkstra 实现用的
    private class Vertex implements Comparable<Vertex> {
        public int id; // 顶点编号 ID
        public int dist; // 从起始顶点到这个顶点的距离
        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
        @Override
        public int compareTo(Vertex o) { // 按照 dist 从小到大排序
            if (o.dist > this.dist) return -1;
            else return 1;
        }
    }

    public void dijkstra(int s, int t) { // 从顶点 s 到顶点 t 的最短路径
        int[] predecessor = new int[this.v]; // 用来还原最短路径
        Vertex[] vertexes = new Vertex[this.v]; // 记录起始顶点到这个顶点的距离
        for (int i = 0; i < v; ++i) { // 初始化 dist 为无穷大
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue<Vertex> queue = new PriorityQueue<>(); // 小顶堆
        boolean[] inQueue = new boolean[this.v]; // 标记是否进入过队列
        queue.add(vertexes[s]); // 先把起始顶点放到队列中
        vertexes[s].dist = 0;
        inQueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex= queue.poll(); // 取 dist 最小的顶点
            if (minVertex.id == t) break; // 最短路径产生了
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // 取出一条 minVetex 相连的边
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                // 找到一条到 nextVertex 更短的路径
                if (minVertex.dist + e.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + e.w; // 更新 dist
                    predecessor[nextVertex.id] = minVertex.id; // 更新前驱顶点
                    if (inQueue[nextVertex.id] == false) { // 如果没有在队列中
                        queue.add(nextVertex); // 就把它放到队列中
                        inQueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }

}
