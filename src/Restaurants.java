import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurants {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("restaurants.dat"));
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int o = scanner.nextInt(); scanner.nextLine();
			List<String> items = new ArrayList<>(o);
			int indexTop = -1;
			double priceTop = -1.0;
			for (int j = 0; j < o; j++) {
				String[] s = scanner.nextLine().split("-");
				String price = "";
				Double r = Double.valueOf(s[1]);
				if(r<=10.0&&0<r){
					price="$";
				} else if (r>=10.01 && r<=20.00) {
					price="$$";
				} else if (r>=20.01 && r<=30.00) {
					price="$$$";
				} else if (r>=30.01) {
					price = "$$$$";
				}
				if(priceTop<r){
					indexTop = j;
					priceTop = r;
				}
				items.add(s[0]+"-"+price);
			}
			for (int i1 = 0; i1 < items.size(); i1++) {
				System.out.println(items.get(i1)+(i1==indexTop ? " Best Value!":""));
			}

		}
	}
}
