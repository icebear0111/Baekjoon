import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();

        graph = new ArrayList<>();
        distance = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                sb.append("INF\n");
            }
            else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (distance[currentVertex] < currentWeight) {
                continue;
            }

            for (Node adj : graph.get(currentVertex)) {
                int newDistance = distance[currentVertex] + adj.weight;

                if (newDistance < distance[adj.vertex]) {
                    distance[adj.vertex] = newDistance;
                    pq.offer(new Node(adj.vertex, newDistance));
                }
            }
        }
    }
}