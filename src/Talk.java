import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Talk {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("talk.dat"));
		Map<String,String> map = new HashMap<>();
		map.put("Alpha","A"); map.put("Bravo","B");
		map.put("Charlie","C"); map.put("Delta","D");
		map.put("Echo","E"); map.put("Foxtrot","F");
		map.put("Golf","G"); map.put("Hotel","H");
		map.put("India","I"); map.put("Juliet","J");
		map.put("Kilo","K"); map.put("Lima","L");
		map.put("Mike","M"); map.put("November","N");
		map.put("Oscar","O"); map.put("Papa","P");
		map.put("Quebec","Q"); map.put("Rome","R");
		map.put("Sierra","S"); map.put("Tango","T");
		map.put("Uniform","U"); map.put("Victor","V");
		map.put("Whiskey","W"); map.put("Xray","X");
		map.put("Yankee","Y"); map.put("Zulu","Z");
		map.put("Blank"," "); map.put("Chameleon",",");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt(); scanner.nextLine();
			String curr = "";
			List<String> line = new ArrayList<>();
			for (int j = 0; j < x; j++) {
				line.add(scanner.next());
			}
			for (String s : line) {
				curr+=map.get(s);
			}
			curr=curr.substring(y%curr.length())+curr.substring(0,y%curr.length());
			System.out.println(curr);
		}
	}
}
