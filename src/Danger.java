import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Danger {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("danger.dat"));
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			scanner.nextLine();
			List<Dino> list = new ArrayList<>();
			for (int j = 0; j < x; j++) {
				String[] dino =scanner.next().split("[-,]");
				list.add(new Dino(dino[0],dino[1],Double.valueOf(dino[2]),Integer.valueOf(dino[3])));
			}
			list.sort(Dino::compareTo);
			System.out.println("Your route will be:");
			for (Dino dino : list) {
				System.out.println(dino.name);
			}
		}
	}
}

class Dino implements Comparable<Dino>{
	public String name;
	String food;
	double weight;
	int speed;

	public Dino(String name,String food, double weight, int speed){
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.speed = speed;
	}
	@Override
	public int compareTo(Dino o) {
		int yuh = -1*this.food.compareTo(o.food);
		if(yuh==0){
			int yah = -1*Double.compare(o.weight,this.weight);
			if(yah==0){
				return this.speed-o.speed;
			}
			return yah;
		}
		return yuh;
	}
}
