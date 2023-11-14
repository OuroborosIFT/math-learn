package matan;

import java.util.stream.Stream;

public class Fibonacci {

	public static long find(int n) {
		if (n <= 1) {
			return 0l;
		} else if (n == 2) {
			return 1l;
		} else {
			return find(n - 1) + find(n - 2);
		}
	}

	public static long sum(int n) {
		return Stream.iterate(new long[]{0l, 1l}, arr -> new long[]{arr[1], arr[0]+ arr[1]})
     			.limit(n)
     			.map(t -> t[0])
    			.mapToLong(Long::longValue)
     			.sum();
	}

	public static void printSequence(int n) {
		Stream.iterate(new long[]{0l, 1l}, arr -> new long[]{arr[1], arr[0]+ arr[1]})
   			.limit(n)
   			.map(y -> y[0])
   			.forEach(x -> System.out.print(x + " "));
	}

}
