import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Guests {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("guests.dat"));
		int n = scanner.nextInt(); scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String[] letters = scanner.nextLine().split("");
			Arrays.sort(letters);
			for (String letter : letters) {
				System.out.print(letter);
			}
			System.out.println();
		}
	}
}
