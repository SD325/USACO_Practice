import java.util.*;
import java.io.*;
public class sort {
	static int n;
	static int[] a;
	public static void main(String[] args) throws IOException {
		String problem = "sort";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		a = new int[n];
		for (int i = 0; i < n; i++) { 
			st = new StringTokenizer(f.readLine()); 
			a[i] = Integer.parseInt(st.nextToken());
		}
		out.println(bubSort());
		f.close();
		out.close();
	}
	public static int bubSort() {
		boolean sorted = false;
		int moo = 0;
		while (!sorted) {
			sorted = true;
			moo++;
			for (int i = 0; i <= n-2; i++) {
				if (a[i+1] < a[i]) {
					swap(i, i+1);
					sorted = false;
				}
			}
		}
		return moo;
	}
	public static void swap(int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
