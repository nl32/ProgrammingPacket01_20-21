import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GuestsWithPQueue {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("guests.dat"));
		int n = scanner.nextInt(); scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String[] letters = scanner.nextLine().split("");
			PriorityQueue<String> queue = new PriorityQueue<>();

			for (String letter : letters) {
				queue.add(letter);
			}
			while(queue.size()!=0){
				System.out.print(queue.remove());
			}
			System.out.println();
		}
	}
}
