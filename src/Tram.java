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
				if(node.equals(end)){
					System.out.println(nodes.get(node));
					break;
				}
			}
		}
	}
	public static Map<String,Integer> GetShortestPath(Map<String,Map<String,Integer>> graph, String start){
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		Map<String,Integer> distance = new HashMap<>();
		Map<String,Boolean> visited = new HashMap<>();
		minHeap.add(new Node(start,0));
		while(minHeap.size()!=0){
			Node curr = minHeap.poll();
			distance.put(curr.getName(),curr.getDistance());
			for (String neighbor : graph.get(curr.getName()).keySet()) {
				int dist = graph.get(curr.getName()).get(neighbor);
				Node node = new Node(neighbor,dist+curr.getDistance());
				if(!visited.containsKey(node.getName())){
					minHeap.add(node.setDistance(Math.min(node.getDistance(),
							distance.containsKey(node.getName())?distance.get(node.getName()):Integer.MAX_VALUE)));
					visited.put(node.getName(),true);
				}
			}
		}
		return distance;
	}

}
class Node implements Comparable<Node>{
	private String name;
	private int distance;
	public Node(String name, int distance){
		this.name = name;
		this.distance = distance;
	}

	public Node setDistance(int distance) {
		this.distance = distance;
		return this;
	}

	public int getDistance() {
		return distance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Node o) {
		return o.distance-this.distance;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Node){
			if(this.name==((Node) obj).name)
				return true;
		}
		return super.equals(obj);
	}
}


