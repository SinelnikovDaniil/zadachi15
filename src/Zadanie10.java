import java.util.LinkedList;
import java.util.Queue;

public class Zadanie10 {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public void GraphTraversal(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    public void breadthFirstTraversal(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        visited[startVertex] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighborVertex = 0; neighborVertex < numVertices; neighborVertex++) {
                if (adjacencyMatrix[currentVertex][neighborVertex] == 1 && !visited[neighborVertex]) {
                    visited[neighborVertex] = true;
                    queue.add(neighborVertex);
                }
            }
        }
    }
}
