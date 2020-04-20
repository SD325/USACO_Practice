import java.util.*;
import java.io.*;
public class teamwork {
	static int n, k;
	static String program_name = "teamwork";
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader(program_name + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(program_name + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			a[i] = Long.parseLong(st.nextToken());
		}
		long dp[] = new long[n+1];
		for (int i = 0; i < n; i++) {
			long max = 0L;
			for (int j = 1; j <= k; j++) {
				if (i+j > n) continue;
				max = Math.max(a[i+j-1], max);
				dp[i+j] = Math.max(dp[i+j], dp[i] + max*j);
			}
		}
		out.println(dp[n]);
		f.close();
		out.close();
	}

}
