import java.util.*;
import java.io.*;
public class pairup {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pairup.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());
		int[][] a = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine(), " ");
			int freq = Integer.parseInt(st.nextToken().trim());
			int y = Integer.parseInt(st.nextToken().trim());
			a[i][0] = y;
			a[i][1] = freq;
		}
		Arrays.sort(a, Comparator.comparingInt(arr -> arr[0]));
		int max = -1;
		int hi  = n-1; int lo = 0;
		while (hi >= lo) {
			max = Math.max(max, a[lo][0] + a[hi][0]);
			if (--a[lo][1] == 0) {
				lo++;
			}
			if (--a[hi][1] == 0) {
				hi--;
			}
		}
		out.println(max);
		f.close();
		out.close();


	}

}
