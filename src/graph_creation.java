import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class graph_creation {
    private LinkedList<Integer> adjacency[];
    public graph_creation(int v){
        adjacency = new LinkedList[v];
        for (int i = 0; i<v; i++){
            adjacency[i] = new LinkedList<Integer>();
        }
    }
    public void insertedge(int s,int d){
        adjacency[s].add(d);
        adjacency[d].add(s);
    }
    public void bfs(int source){
        boolean visited_node[] = new boolean[adjacency.length];
        int parent_node[] = new int[adjacency.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited_node[source] = true;
        parent_node[source] = -1;
        while (!q.isEmpty()){
            int p = q.poll();
            System.out.println(p);
            for (int i : adjacency[p]) {
                if (visited_node[i] != true) {
                    visited_node[i] = true;
                    q.add(i);
                    parent_node[i] = p;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF VERTICES AND EDGES");
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph_creation g =new graph_creation(v);
        System.out.println("Enter edges");
        for (int i = 0; i<e; i++){
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.insertedge(s,d);
        }
        System.out.println("enter source for bfs traverser");
        int source = sc.nextInt();
        g.bfs(source);
    }
}
