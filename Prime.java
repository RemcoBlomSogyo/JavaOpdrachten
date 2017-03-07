/*
	The program calculates what prime number 100001 is.
	
	Made by Remco Blom
*/

import java.util.ArrayList;

public class Prime {
	
	public static void main (String[] args) {
		int findPrime = 10001;
		int counter = 2;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		System.out.println(primes.size() + " : " + counter);
		
		// search for prime numbers until prime number 10001 is found
		while (primes.size() != findPrime) {
			counter++;
			boolean isPrime = true;
			for (Integer prime : primes) {
				if (counter % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(counter);
				System.out.println(primes.size() + " : " + counter);
			}
		}
	}
}