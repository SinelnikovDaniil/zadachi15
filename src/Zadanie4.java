import java.util.*;

public class Zadanie4 {
    public static void main(String[] args) {
        // Граф городов и летных сообщений
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A"));
        graph.put("C", Arrays.asList("A", "D"));
        graph.put("D", Arrays.asList("C"));
        graph.put("E", Arrays.asList("F"));
        graph.put("F", Arrays.asList("E"));

        int isolatedCountries = findIsolatedCountries(graph);
        System.out.println("Число изолированных стран: " + isolatedCountries);
    }

    private static int findIsolatedCountries(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        int isolatedCountries = 0;

        for (String city : graph.keySet()) {
            if (!visited.contains(city)) {
                bfs(graph, visited, city);
                isolatedCountries++;
            }
        }

        return isolatedCountries;
    }

    private static void bfs(Map<String, List<String>> graph, Set<String> visited, String startCity) {
        Queue<String> queue = new LinkedList<>();
        queue.add(startCity);
        visited.add(startCity);

        while (!queue.isEmpty()) {
            String city = queue.poll();

            List<String> neighbors = graph.get(city);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }
}

