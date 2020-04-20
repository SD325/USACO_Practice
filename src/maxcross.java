import java.util.*;
import java.io.*;
public class maxcross {
	static int n;
	static int k;
	static int b;
	static boolean[] broken;
	public static void main(String[] args) throws IOException {
		String problem = "maxcross";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		broken = new boolean[n + 1];
		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(f.readLine());
			int ind = Integer.parseInt(st.nextToken());
			broken[ind] = true;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n-k+1; i++) 
			min = Math.min(min, k - numFixed(i, i+k));
		out.println(min);
		f.close();
		out.close();
	}
	public static int numFixed(int start, int end) {
		int ret = 0;
		for (int i = start; i < end; i++)
			if (!broken[i]) ret++;
		return ret;
	}
}
