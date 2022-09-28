import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Exhibits {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("exhibits.dat"));
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt(); scanner.nextLine();
			String[][] map = new String[10][10];
			for (int j = 0; j < 10; j++) {
				map[j] = scanner.nextLine().split("");
			}
			for (int j = 0; j < x; j++) {
				System.out.println("the exhibits(s) closest are:");
				String[] p = scanner.nextLine().split(",");
				List<String> closest = closest(Integer.valueOf(p[0]),Integer.valueOf(p[1]),map);
				for (String s : closest) {
					System.out.print(s + " ");
				}
				System.out.println();
			}
		}

	}
	public static List<String> closest(int x,int y, String[][] map){
		List<String> points = new ArrayList<>();
		Queue<Point> queue = new LinkedList();
		Map<Point,Boolean> visited = new HashMap<>();
		queue.add(new Point(x,y));
		while(queue.size()!=0&&points.size()==0){
			int level = queue.size();
			for (int i = 0; i < level; i++) {
				Point current = queue.remove();
				if (current.x < 10 && current.x > 0 && current.y < 10 && current.y > 0) {
					if (!visited.containsKey(current) || visited.containsKey(current) && !visited.get(current)) {
						visited.put(current, true);
						if (map[current.x][current.y].matches("[a-zA-Z]")) {
							points.add(map[current.x][current.y]);
						}
						if (map[current.x][current.y].equals("#")) {
						} else {
							queue.add(new Point(x - 1, y));
							queue.add(new Point(x + 1, y));
							queue.add(new Point(x, y - 1));
							queue.add(new Point(x, y + 1));
						}
					}
				}
			}
			level++;
		}
		return points;
	}
}




