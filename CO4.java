public class CO4 {

    public static void main(String[] args) {

        int V = 5;
        int INF = 99999;

        int[][] graph = {
                {0, 4, 2, INF, INF},
                {INF, 0, 3, 2, 3},
                {INF, 1, 0, 4, 5},
                {INF, INF, INF, 0, INF},
                {INF, INF, INF, -2, 0}
        };

        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = INF;
        }

        dist[0] = 0; // Command Center

        for (int k = 1; k < V; k++) {

            for (int u = 0; u < V; u++) {

                for (int v = 0; v < V; v++) {

                    if (graph[u][v] != INF &&
                        dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {

                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        System.out.println("====================================");
        System.out.println("CivicEye Smart City Incident System");
        System.out.println("Bellman-Ford Route Optimization");
        System.out.println("====================================");

        System.out.println("\nShortest Distance from Command Center:");

        for (int i = 0; i < V; i++) {
            System.out.println("Zone " + i + " : " + dist[i] + " minutes");
        }
    }
}