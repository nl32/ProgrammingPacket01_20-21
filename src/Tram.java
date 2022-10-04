import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tram {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("tram.dat"));
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		scanner.nextLine();
		String[] nodeNames = scanner.nextLine().split(" ");
		Map<String,Map<String,Integer>> graph = new HashMap<>();
		for (String nodeName : nodeNames) {
			graph.put(nodeName,new HashMap<>());
		}
		//add edges
		for (int i = 0; i < x; i++) {
			String[] connection = scanner.nextLine().split(" ");
			String first = connection[0];
			String second = connection[1];
			int distance = Integer.valueOf(connection[2]);
			graph.get(first).put(second,distance);
			graph.get(second).put(first,distance);
		}
		//which routes to find
		for (int i = 0; i < y; i++) {
			String[] s = scanner.nextLine().split(" ");
			String start = s[0];
			String end = s[1];
			Map<String,Integer> nodes = GetShortestPath(graph,start);
			for (String node : nodes.keySet()) {
				if (node.equals(end)) {
					if(nodes.get(node)==Integer.MAX_VALUE){
						System.out.println("get to walkin pard'ner");
						break;
					}
					System.out.println(nodes.get(node));
					break;
				}
			}
		}
	}
	public static Map<String,Integer> GetShortestPath(Map<String,Map<String,Integer>> graph, String start){
		Map<String,Integer> distances = new HashMap<>();
		Map<String,Boolean> marked = new HashMap<>();
		for (String s : graph.keySet()) {
			distances.put(s,Integer.MAX_VALUE);
			marked.put(s,false);
		}
		distances.put(start,0);
		for (String s : distances.keySet()) {
			String v = "";
			for (String t : distances.keySet()) {
				if(!marked.get(t) && (v.equals("") || distances.get(t)< distances.get(v)))
					v=t;
			}
			if(distances.get(v)==Integer.MAX_VALUE){
				break;
			}
			marked.put(v,true);
			for (String to : graph.get(v).keySet()) {
				int len = graph.get(v).get(to);
				if(distances.get(v) + len < distances.get(to))
					distances.put(to, distances.get(v)+len);
			}
		}
		return distances;
	}

}
