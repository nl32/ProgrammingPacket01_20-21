import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lines {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("lines.dat"));
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int o = scanner.nextInt(); scanner.nextLine();
			String s ="";
			int index = Integer.MAX_VALUE;
			for (int j = 0; j < o; j++) {
				String[] curr = scanner.nextLine().split(" : ");
				int cIndex = curr[1].indexOf("S");
				if(cIndex!=-1&&cIndex<index){
					s = curr[0];
					index=cIndex;
				}
			}
			System.out.println(s);
		}
	}
}
