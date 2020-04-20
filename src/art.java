import java.io.*;
import java.util.*;
public class art {
	static int n;
	static int[][] canvas;
	public static boolean onTop(int i, int j) {
		int top = n;
		int bottom = 0;
		int left = n;
		int right = 0;
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if (canvas[a][b] == j) {
					top = Math.min(top, a);
					bottom = Math.max(bottom, a);
					left = Math.min(left, b);
					right = Math.max(right, b);
				}
			}
		}

		for (int a = top; a <= bottom; a++) {
			for (int b = left; b <= right; b++) {
				if (canvas[a][b] == i) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("art.in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));

		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		// n x n grid
		n = Integer.parseInt(st.nextToken().trim());

		canvas = new int[n][n]; 
		HashSet <Integer> colors = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(f.readLine(), "");
			String str = st1.nextToken().trim();
			for (int j = 0; j < n; j++) {
				canvas[i][j] = Integer.parseInt(str.substring(j, j+1));
				colors.add(canvas[i][j]);
				//System.out.print(canvas[i][j]);
			}
			//System.out.println();
		}
		//if (colors.contains(0)) colors.remove(0);
		//System.out.println(colors);
		int sol = 0;
		for (int i = 1; i <= 9; i++) {
			if (colors.contains(i)) {
				boolean on_bottom = true;
				for (int j = 1; j <= 9; j++) {
					if (j != i && colors.contains(j) && onTop(i, j)) {
						on_bottom = false;
					}
				}
				if (on_bottom) sol++;
			}
		}
		out.println(sol);

		f.close();
		out.close();

	}

}
