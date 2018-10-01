package adaprograms;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Hashing_Sum {
	
	private HashMap<Long, Boolean> hashing;
	private ArrayList<Long> keys;
	
	
	public Hashing_Sum() {
		int i = 0;
		keys = new ArrayList<Long>();
		Scanner scan = new Scanner(System.in);
		hashing = new HashMap<Long, Boolean>();
		while (scan.hasNextLong()) {
			//StdOut.println("Here\n");
			long a = scan.nextLong();
			if (!hashing.containsKey(a)) {
				hashing.put(a, true);
				keys.add(a);
			}
		}
		
	}
	
	public int count() {
		int k = 0;
		for (long sum = -10000; sum <= 10000; sum++) {
			for (int i = 0; i < keys.size(); i++) {
				if (hashing.containsKey(sum - keys.get(i)))
				{
					k++;
					break;
				}
			}
			System.out.println(sum);
		}
		return k;
	}
	
	public static void main(String [] args) {
		Hashing_Sum source = new Hashing_Sum();
		System.out.println("Number is %d\n"+source.count());
	}
}