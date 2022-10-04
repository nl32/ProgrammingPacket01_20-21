import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Time {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("time.dat"));
		int n = scanner.nextInt(); scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String[] s = scanner.nextLine().trim().split(":");
			System.out.println(Integer.valueOf(s[0])+Integer.valueOf(s[1]));
		}

	}

}
