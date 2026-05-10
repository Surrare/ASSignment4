import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g) {
        int startNode = 0; // Assuming node 0 is always created first

        // Time BFS
        long startBfs = System.nanoTime();
        g.bfs(startNode);
        long endBfs = System.nanoTime();

        // Time DFS
        long startDfs = System.nanoTime();
        g.dfs(startNode);
        long endDfs = System.nanoTime();

        printResults(g.getSize(), endBfs - startBfs, endDfs - startDfs);
    }

    public void runMultipleTests() {
        System.out.println("--- Small Graph (10 vertices) ---");
        Graph small = generateRandomGraph(10, 15);
        small.printGraph();
        runTraversals(small);

        System.out.println("\n--- Medium Graph (30 vertices) ---");
        Graph medium = generateRandomGraph(30, 60);
        runTraversals(medium);

        System.out.println("\n--- Large Graph (100 vertices) ---");
        Graph large = generateRandomGraph(100, 300);
        runTraversals(large);
    }

    public void printResults(int size, long bfsTime, long dfsTime) {
        System.out.println("Execution Results for " + size + " vertices:");
        System.out.println("BFS Execution Time: " + bfsTime + " ns");
        System.out.println("DFS Execution Time: " + dfsTime + " ns");
    }

    private Graph generateRandomGraph(int numVertices, int numEdges) {
        Graph g = new Graph();
        for (int i = 0; i < numVertices; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < numEdges; i++) {
            int from = rand.nextInt(numVertices);
            int to = rand.nextInt(numVertices);
            if (from != to) {
                g.addEdge(from, to);
            }
        }
        return g;
    }
}