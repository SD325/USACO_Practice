//Method: prefix sums
import java.util.*;
import java.io.*;
public class homework {
	static int n;
	static int[] scores;
	public static void main(String[] args) throws IOException {
		String problem = "homework";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		scores = new int[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) scores[i] = Integer.parseInt(st.nextToken());
		double[] finalScores = new double[n];
		int min = scores[n-1];
		double maxScore = 0;
		int sum = 0;
		for (int i = n-1; i >= 0; i--) {
			if (i == n-1) continue;
			int curr = scores[i];
			int old = min;
			min = Math.min(min, curr);
			sum += curr + old - min;
			finalScores[i] = (double)sum/(n-i-1);
			maxScore = Math.max(maxScore, finalScores[i]);
		}
		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			if (finalScores[i] == maxScore) sol.add(i);
		for (Integer i : sol) out.println(i);
		f.close();
		out.close();
	}

}
