import java.io.*;
import java.util.*;
public class haybales {
	public static int n;
	public static int q;
	public static ArrayList<Integer> bales;
	public static int count(int i) {
		if(bales.get(0) > i) return 0;
		int min = 0;
		int max = n-1;
		//binary search
		while(min < max) {
			int mid = (min+max+1)/2;
			if (bales.get(mid) <= i) min = mid;
			else max = mid-1;
		}
		return min + 1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());
		q = Integer.parseInt(st.nextToken().trim());
		
		bales = new ArrayList<Integer>();
		st = new StringTokenizer(f.readLine(), " "); 
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken().trim());
			bales.add(temp);
		}
		Collections.sort(bales);
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(f.readLine(), " ");
			int a = Integer.parseInt(st.nextToken().trim());
			int b = Integer.parseInt(st.nextToken().trim());
			System.out.println(count(b) - count(a - 1));
		}
		f.close();
		out.close();
	}
}
