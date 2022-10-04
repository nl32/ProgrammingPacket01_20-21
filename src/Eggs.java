import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Eggs {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("eggs.dat"));
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			if(x>7){
				System.out.println("Big");
			} else if (x<3) {
				System.out.println("Small");
			}else {
				System.out.println("Average");
			}
		}
	}
}
