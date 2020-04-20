import java.util.*;
import java.io.*;
public class BarnPainting {
	static int n, k;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static final long MOD = (long) (1e9+7);
	static long[][] dp;
	static int[] color;
	static String program_name = "barnpainting";
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(program_name + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(program_name + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		color = new int[n];
		Arrays.fill(color, -1);
		dp = new long[n][3];
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(f.readLine());
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			color[b] = c;
		}
		long ret = solve(0, 0, -1, -1) + solve(0, 1, -1, -1) + solve(0, 2, -1, -1);
		out.println(ret % MOD);
		f.close();
		out.close();
	}
	public static long solve(int currV, int currC, int parV, int parC) {
		if (currC == parC || (color[currV] >= 0 && color[currV] != currC)) return 0;
		if (dp[currV][currC] >= 0) return dp[currV][currC];
		dp[currV][currC] = 1;
		for (int v : adj.get(currV)) {
			if (v == parV) continue;
			long children_colors = 0;
			for (int col = 0; col < 3; col++) {
				children_colors += solve(v, col, currV, currC);
				children_colors %= MOD;
			}
			dp[currV][currC] *= children_colors;
			dp[currV][currC] %= MOD;
		}
		return dp[currV][currC];
	}

}
