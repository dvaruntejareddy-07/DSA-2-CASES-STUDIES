import java.util.*;

public class CO3 {
    static int V = 5;

    static void BFS(int[][] graph, int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int i = 0; i < V; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    static void DFS(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < V; i++) {
            if (graph[node][i] != 0 && !visited[i])
                DFS(graph, i, visited);
        }
    }

    static void primMST(int[][] graph) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int min = Integer.MAX_VALUE, u = -1;

            for (int v = 0; v < V; v++) {
                if (!mstSet[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 &&
                        !mstSet[v] &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("\nMST Edges:");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i);
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        System.out.print("BFS: ");
        BFS(graph, 0);

        System.out.print("\nDFS: ");
        DFS(graph, 0, new boolean[V]);

        primMST(graph);
    }
}