import java.util.*;
import java.io.*;
public class diamond {
	static int n;
	static int k;
	static ArrayList <Integer> diamonds;
	public static int getNumDiamonds(int start_index) {
		int size = diamonds.size();
		int count = 0;
		for (int i = 0; i < size; i++) {
			int curr = diamonds.get(i);
			if (curr >= diamonds.get(start_index)) {
				if (curr <= diamonds.get(start_index) + k) {
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());
		k = Integer.parseInt(st.nextToken().trim());
		diamonds = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(f.readLine());
			diamonds.add(Integer.parseInt(st1.nextToken().trim()));
		}
		Collections.sort(diamonds);
		//System.out.println(diamonds);
		
		int max = Collections.max(diamonds) - k;
		int size = diamonds.size(); 
		if (max <= 0) {
			out.println(size);
			f.close();
			out.close();
			return;
		}
		int num_diamonds = -1;
		for (int i = 0; i < size; i++) {
			if (diamonds.get(i) > max) break;
			num_diamonds = Math.max(num_diamonds, getNumDiamonds(i));
		}
		out.println(num_diamonds);
		f.close();
		out.close();
	}

}
