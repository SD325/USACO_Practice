import java.io.*;
import java.util.*;

public class measurement {
	static long[] values;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("measurement.in"));
		PrintWriter pw = new PrintWriter(new File("measurement.out"));

		int total = scanner.nextInt();
		long G = scanner.nextLong();
		values = new long[1000];
		for (long l : values) {
			l = G;
		}
		TreeMap<Integer, String> dates = new TreeMap<>();

		for (int i = 0; i < total; i++) {
			dates.put(scanner.nextInt(), scanner.next() + " " + scanner.nextLong());
		}
		int changes = 0;
		for (int i = 0; i < total; i++) {
			ArrayList<Integer> max = max();
			Collections.sort(max);

			int first = dates.firstKey();
			String s = dates.get(first);
			String[] parts = s.split(" ");
			values[Integer.parseInt(parts[0])] += Integer.parseInt(parts[1]);

			ArrayList<Integer> newMax = max();
			Collections.sort(newMax);
			if (changed(max, newMax))
				changes++;
			dates.remove(first);
		}
		pw.println(changes);
		pw.close();
		scanner.close();
	}

	public static ArrayList<Integer> max() {
		ArrayList<Integer> ret = new ArrayList<>();
		long max = values[0];
		for (int i = 0; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		for (int i = 0; i < values.length; i++) {
			if (values[i] == max) {
				ret.add(i);
			}
		}
		return ret;
	}

	public static boolean changed(ArrayList<Integer> old, ArrayList<Integer> max) {
		if (old.size() != max.size())
			return true;
		else {
			for (int i = 0; i < old.size(); i++) {
				if (old.get(i) != max.get(i))
					return true;
			}
			return false;
		}
	}
}