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
			boolean yar = true;
			for (int j = 0; j < x; j++) {
				String[] p = scanner.nextLine().split(",");
				if(yar) {
					List<String> closest = closest(Integer.valueOf(p[0]), Integer.valueOf(p[1]), map);
					if (closest.size() != 0) {
						System.out.println("the exhibits(s) closest are:");
						for (String s : closest) {
							System.out.print(s + " ");
						}
						System.out.println();
					} else {
						System.out.println("Oops, sorry we're out of dinosaurs here!");
						yar = false;
					}
				}
			}
		}

	}
	public static List<String> closest(int x,int y, String[][] map){
		List<String> points = new ArrayList<>();
		Queue<Point> queue = new LinkedList();
		Set<Point> visited = new HashSet<>();
		queue.add(new Point(x,y));
		while(queue.size()!=0&&points.size()==0){
			int level = queue.size();
			for (int i = 0; i < level; i++) {
				Point current = queue.remove();
				if (current.x < 10 && current.x > -1 && current.y < 10 && current.y > -1) {
					if (!visited.contains(current) ) {
						visited.add(current);
						if (map[current.x][current.y].matches("[a-zA-Z]")) {
							points.add(map[current.x][current.y]);
						}
						if (!map[current.x][current.y].equals("#")) {
							queue.add(new Point(current.x - 1, current.y));
							queue.add(new Point(current.x + 1, current.y));
							queue.add(new Point(current.x, current.y - 1));
							queue.add(new Point(current.x, current.y + 1));
						}
					}
				}
			}
			level++;
		}
		return points;
	}
}




