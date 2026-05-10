import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Edge>> adjList;

    public Graph() {
        this.vertices = new HashMap<>();
        this.adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.putIfAbsent(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        Vertex source = vertices.get(from);
        Vertex dest = vertices.get(to);

        if (source != null && dest != null) {
            // Adding an undirected edge (adds both directions)
            adjList.get(from).add(new Edge(source, dest));
            adjList.get(to).add(new Edge(dest, source));
        }
    }

    public void printGraph() {
        for (int vId : adjList.keySet()) {
            System.out.print("Vertex " + vId + " is connected to: ");
            for (Edge e : adjList.get(vId)) {
                System.out.print(e.getDestination().getId() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        if (!vertices.containsKey(start)) return;

        boolean shouldPrint = vertices.size() <= 10; // Only print traversal for small graphs
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        if (shouldPrint) System.out.print("BFS Traversal Order: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (shouldPrint) System.out.print(current + " ");

            for (Edge edge : adjList.get(current)) {
                int neighbor = edge.getDestination().getId();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        if (shouldPrint) System.out.println();
    }

    public void dfs(int start) {
        if (!vertices.containsKey(start)) return;

        boolean shouldPrint = vertices.size() <= 10;
        Set<Integer> visited = new HashSet<>();

        if (shouldPrint) System.out.print("DFS Traversal Order: ");
        dfsHelper(start, visited, shouldPrint);
        if (shouldPrint) System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited, boolean shouldPrint) {
        visited.add(current);
        if (shouldPrint) System.out.print(current + " ");

        for (Edge edge : adjList.get(current)) {
            int neighbor = edge.getDestination().getId();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, shouldPrint);
            }
        }
    }

    // get graph size
    public int getSize() {
        return vertices.size();
    }
}