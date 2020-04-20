import java.util.*;
import java.io.*;
public class lemonade {
	static int n;
	public static void main(String[] args) throws IOException {
		String problem = "lemonade";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		int[] w = new int[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) w[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(w);
		int inLine = 0;
		for (int i = n-1; i >= 0; i--) {
			if (w[i] < inLine) break;
			else inLine++;
		}
		out.println(inLine);
		f.close();
		out.close();
	}

}
