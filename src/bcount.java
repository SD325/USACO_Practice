import java.util.*;
import java.io.*;
public class bcount {
	static int n;
	static int q;
	public static void main(String[] args) throws IOException {
		String problem = "bcount";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		int[] prefix1 = new int[n+1];
		int[] prefix2 = new int[n+1];
		int[] prefix3 = new int[n+1];
		//index 0 of all prefixes are 0
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(f.readLine());
			int breed = Integer.parseInt(st.nextToken());
			prefix1[i] = prefix1[i-1];
			prefix2[i] = prefix2[i-1];
			prefix3[i] = prefix3[i-1];
			if (breed == 1) prefix1[i]++;
			else if (breed == 2) prefix2[i]++;
			else prefix3[i]++;
		}
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(f.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			out.println((prefix1[e] - prefix1[s-1]) + " " + (prefix2[e] - prefix2[s-1]) + " " + (prefix3[e] - prefix3[s-1]));
		}
		f.close();
		out.close();
	}

}
