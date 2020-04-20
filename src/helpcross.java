import java.util.*;
import java.io.*;
public class helpcross {
	static int[] chickens;
	static HashMap<Integer, ArrayList<Integer>> valid = new HashMap<>();
	static HashMap<Integer, Integer> ends = new HashMap<>();
	static boolean[] taken;
	public static void main(String[] args) throws IOException {
		String problem = "helpcross";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num_chickens = Integer.parseInt(st.nextToken());
		int num_cows = Integer.parseInt(st.nextToken());
		chickens = new int[num_chickens];
		for (int i = 0; i < num_chickens; i++) {
			st = new StringTokenizer(f.readLine());
			chickens[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < num_cows; i++) {
			st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ends.put(i, end);
			for (int j = 0; j < num_chickens; j++) {
				if (start <= chickens[j] && chickens[j] <= end) addToMap(j, i);
			}
		}
		taken = new boolean[num_chickens];
		int count = 0;
		for (int i = 0; i < num_chickens; i++) {
			int currCow = returnFirstToFinish(valid.get(i));
			if (currCow != -1) {
				count++;
				taken[currCow] = true;
			}
		}
		out.println(count);
		f.close();
		out.close();
	}
	public static int returnFirstToFinish(ArrayList<Integer> cows) {
		if (cows == null || cows.size() == 0) return -1;
		int least = Integer.MAX_VALUE;
		int ind = -1;
		for (Integer i : cows) {
			if (taken[i]) continue;
			int old = least;
			least = Math.min(least, ends.get(i));
			if (least != old) ind = i;
		}
		return ind;
		
	}
	public static void addToMap(int ch_ind, int cow) {
		if (!valid.containsKey(ch_ind)) {
			valid.put(ch_ind, new ArrayList<Integer>());
		}
		ArrayList<Integer> temp = valid.get(ch_ind);
		temp.add(cow);
		valid.put(ch_ind, temp);
	}
}
