import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class graph_traverser_DFS {
    private LinkedList<Integer> adjecency[];
    public graph_traverser_DFS(int v){
        adjecency = new  LinkedList[v];
        for (int i = 0; i<v; i++){
            adjecency[i] = new LinkedList<>();
        }
    }
    public void insert(int s, int d){
        adjecency[s].add(d);
        adjecency[d].add(s);
    }
    public void Dfs(int source){
        boolean visited_node[] = new boolean[adjecency.length];
        int parent_node[] = new int[adjecency.length];
        Stack<Integer> q = new Stack<>();
        q.add(source);
        visited_node[source] = true;
        parent_node[source] = -1;
        while (!q.isEmpty()){
            int p = q.pop();
            System.out.println(p);
            for (int i : adjecency[p]) {
                if (visited_node[i] != true) {
                    visited_node[i] = true;
                    q.add(i);
                    parent_node[i] = p;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        System.out.println("ENTER THE VERTICES AND EDGES:");
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph_traverser_DFS b = new graph_traverser_DFS(v);
        System.out.println("Edges: ");
        for (int i = 0; i<e; i++){
            int s = sc.nextInt();
            int d = sc.nextInt();
            b.insert(s,d);
        }
        System.out.println("enter source for bfs traverser");
        int source = sc.nextInt();
        b.Dfs(source);
    }

}
