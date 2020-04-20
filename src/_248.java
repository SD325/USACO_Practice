import java.util.*;
import java.io.*;
public class _248 {
	static int n;
	static String program_name = "248";
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(program_name + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(program_name + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[n][n];
		int ans = 0;
		for (int len = 0; len < n; len++) {
			for (int i = 0; i + len < n; i++) {
				if (len == 0) dp[i][len] = a[i];
				else {
					for (int k = 0; k < len; k++) {
						if (dp[i][k] == dp[i + k + 1][len - k - 1] && dp[i][k] != 0) {
							dp[i][len] = Math.max(dp[i][len], dp[i][k] + 1);
						}
					}
					ans = Math.max(ans, dp[i][len]);
				}
			}
		}
		out.println(ans);
		f.close();
		out.close();
	}

}
