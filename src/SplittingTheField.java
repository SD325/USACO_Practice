import java.util.*;
import java.io.*;
public class SplittingTheField {
	static int n;
	static ArrayList<Pair<Long, Long>> coords = new ArrayList<>();
	static String program_name = "split";
	public static void switch_xy() {
		for (Pair<Long, Long> p : coords) {
			long temp = p.f;
			p.f = p.s;
			p.s = temp;
		}
	}
	public static long computeMinArea(ArrayList<Long> all_x, long min_x, long max_x, long min_y, long max_y) {
		Collections.sort(all_x);
		long minArea = Long.MAX_VALUE;
		for (int i = 0; i < all_x.size()-1; i++) {
			long this_x = all_x.get(i);
			
		}
		return minArea;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(program_name + ".in"));                                              
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(program_name + ".out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		long min_x = Long.MAX_VALUE, min_y = Long.MAX_VALUE;
		long max_x = Long.MIN_VALUE, max_y = Long.MIN_VALUE;
		HashSet<Long> all_x = new HashSet<>();
		HashSet<Long> all_y = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			long this_x = Long.parseLong(st.nextToken());
			long this_y = Long.parseLong(st.nextToken());
			all_x.add(this_x); all_y.add(this_y);
			min_x = Math.min(min_x, this_x);
			max_x = Math.max(max_x, this_x);
			min_y = Math.min(min_y, this_y);
			max_y = Math.max(max_y, this_y);
			coords.add(new Pair<Long, Long>(this_x, this_y));
		}
		long totalArea = (max_x - min_x) * (max_y - min_y);
		
		Collections.sort(coords);
		long min1 = computeMinArea(new ArrayList<Long>(all_x), min_x, max_x, min_y, max_y);
		switch_xy();
		Collections.sort(coords);
		long min2 = computeMinArea(new ArrayList<Long>(all_y), min_y, max_y, min_x, max_x);
		System.out.println(totalArea - Math.min(min1, min2));
		f.close();
		out.close();
	}

}


class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>> {
    public S f;
    public T s;
    
    public Pair(S first, T second) {
        this.f = first;
        this.s = second;
    }

    @Override
    public int compareTo(Pair<S, T> o) {
        int t = this.f.compareTo(o.f);
        if (t == 0) return this.s.compareTo(o.s);
        return t;
    }
    
    @Override
    public int hashCode() {
        return (31 + this.f.hashCode()) * 31 + this.s.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        if (o == this) return true;
        Pair p = (Pair) o;
        return this.f.equals(p.f) && this.s.equals(p.s);
    }
    
    @Override
    public String toString() {
        return "(" + this.f + ", " + this.s + ")";
    }
}