/*
	The program calculates what prime number 100001 is.
	
	Made by Remco Blom
*/
import java.util.Arrays;

public class Prime {
	
	public static void main (String[] args) {
		int counter = 2;
		int primeCounter = 1;
		int[] primes = {2};
		System.out.println(primeCounter + " : " + counter);
		
		int primeNumber = 10001;
		
		// search for prime numbers until prime number 10001 is found
		while (primeCounter != primeNumber) {
			counter += 1;
			boolean isPrime = true;
			for (int prime : primes) {
				if (counter % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeCounter += 1;
				primes = Arrays.copyOf(primes, primeCounter);
				primes[primes.length - 1] = counter;
				System.out.println(primeCounter + " : " + counter);
			}
		}
	}
}