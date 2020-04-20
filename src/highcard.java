import java.util.*;
import java.io.*;
public class highcard {
	static int n;
	static ArrayList<Integer> opp;
	public static void main(String[] args) throws IOException {
		String problem = "highcard";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		boolean[] in = new boolean[2*n+1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			in[Integer.parseInt(st.nextToken())] = true;
		}
		ArrayList<Integer> elsie = new ArrayList<Integer>();
		ArrayList<Integer> bessie = new ArrayList<Integer>();
		for (int i = 1; i < 2*n+1; i++) {
			if (in[i]) elsie.add(i);
			else bessie.add(i);
		}
		int eInd = 0;
		int bInd = 0;
		int win = 0;
		while (eInd < n && bInd < n) {
			if (bessie.get(bInd) > elsie.get(eInd)) {
				bInd++;
				eInd++;
				win++;
			}
			else bInd++;
		}
		out.println(win);
		f.close();
		out.close();
	}
}
