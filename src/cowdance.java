import java.util.*;
import java.io.*;
public class cowdance {
	public static int n;
	public static int tmax;
	public static int[] d;
	public static void main(String[] args) throws IOException{
		String problem = "cowdance";
		BufferedReader f = new BufferedReader(new FileReader(problem + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problem + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine(), " ");
		n = Integer.parseInt(st.nextToken().trim());
		tmax = Integer.parseInt(st.nextToken().trim());
		d = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine(), " ");
			d[i] = Integer.parseInt(st.nextToken().trim());
		}
		// n is max value
			// binary search between 1 and n
		int min = 1;
		int max = n; 
        while (min != max) { 
        	int mid = (min+max)/2;
			if(possible(mid)) max = mid;
			else min = mid+1;
        } 
        out.println(max); 
		out.close();
		f.close();
	}
	public static boolean possible(int x) {
		int lastTime = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < d.length; i++) {
			//remove cow taking shortest amount of time
			if (q.size() == x) lastTime = q.poll();
			//if adding another cow's time to the last time
			if (lastTime + d[i] > tmax) return false;
			q.add(lastTime + d[i]);
		}
		return true;
	}

}