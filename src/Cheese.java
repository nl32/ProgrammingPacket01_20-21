import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cheese {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("cheese.dat"));
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			if(x==1776){
				System.out.println("YEP");
			}else{
				System.out.println("NOPE");
			}
		}

	}
}
