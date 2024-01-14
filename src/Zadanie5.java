import java.util.*;

public class Zadanie5 {
    public static void main(String[] args) {
        // Граф родительских связей
        Map<String, String> parentMap = new HashMap<>();
        parentMap.put("p1", "p2");
        parentMap.put("p2", "p3");
        parentMap.put("p3", "p4");
        parentMap.put("p4", "p5");
        parentMap.put("p5", "p6");
        parentMap.put("p6", "q");

        String p = "p1";
        String q = "q";

        List<String> parentChain = findParentChain(parentMap, p, q);
        if (parentChain != null) {
            System.out.println("Соединяющая цепь родителей:");
            for (String person : parentChain) {
                System.out.println(person);
            }
        } else {
            System.out.println("Цепь родителей не найдена");
        }
    }

    private static List<String> findParentChain(Map<String, String> parentMap, String p, String q) {
        Set<String> visited = new HashSet<>();
        List<String> parentChain = new ArrayList<>();

        if (dfs(parentMap, visited, parentChain, p, q)) {
            return parentChain;
        }

        return null;
    }

    private static boolean dfs(Map<String, String> parentMap, Set<String> visited, List<String> parentChain, String current, String q) {
        visited.add(current);

        if (current.equals(q)) {
            parentChain.add(current);
            return true;
        }

        String parent = parentMap.get(current);
        if (parent != null && !visited.contains(parent)) {
            if (dfs(parentMap, visited, parentChain, parent, q)) {
                parentChain.add(current);
                return true;
            }
        }

        return false;
    }
}

