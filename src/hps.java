import java.util.*;
import java.io.*;
public class hps {
	public static int n;
	public static void main(String[] args) throws IOException {
		String problem = "hps";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		int[] gest = new int[n];
		int[] reverse = new int[n];
		int h = 0; int p = 0; int s = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			String sym = st.nextToken();
			if (sym.equals("H")) { gest[i] = 0; reverse[n-i-1] = 0; }
			if (sym.equals("P")) { gest[i] = 1; reverse[n-i-1] = 1; }
			if (sym.equals("S")) { gest[i] = 2; reverse[n-i-1] = 2; }
		}
		int[][] prefix = fill(gest);
		int[][] suffix = fill(reverse);
		
		int sol = 0;
		for (int i = 0; i <= n; i++) {
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					sol = Math.max(sol, prefix[x][i] + suffix[y][n-i]);
				}
			}
		}
		out.println(sol);
		f.close();
		out.close();
	}
	public static int[][] fill(int[] a) {
		int[][] filled = new int[3][n+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				filled[j][i+1] = filled[j][i];
			}
			filled[a[i]][i+1]++;
		}
		return filled;
	}

}
