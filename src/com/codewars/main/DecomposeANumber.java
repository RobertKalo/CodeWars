/*Description:

Decompose a number num into an array (tuple in Haskell, array of arrays long[][] in C# or Java) of the form [[k1,k2,k3...], r], ([k1,k2,k3...], r) in Haskell, [[k1,k2,k3...], [r]] in C# or Java) such that:

each kn is more than one
eack kn is maximized (first maximizing for 2 then 3 then 4 and so on)
and 2k1 + 3k2 + 4k3 + ... + nkn-1 + r = num
Examples

# when there are no `k` more than 1:

3 

[[], 3] = 

3

# when the remainder is zero:

8330475

[[22, 13, 10, 8, 7, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2], 0] = 

2 ^ 22 + 3 ^ 13 + 4 ^ 10 + 5 ^ 8 + 6 ^ 7 + 7 ^ 6 + 8 ^ 6 + 9 ^ 5 + 10 ^ 5 + 11 ^ 5 + 12 ^ 4 + 13 ^ 4 + 14 ^ 4 + 15 ^ 3 + 16 ^ 3 + 17 ^ 3 + 18 ^ 3 + 19 ^ 3 + 20 ^ 3 + 21 ^ 2 + 22 ^ 2 + 23 ^ 2 + 24 ^ 2 + 0 = 8330475

# when there is both `k` and a remainder:

26 

[[4, 2], 1] = 

2 ^ 4 + 3 ^ 2 + 1 = 26

# when there is neither `k` nor a remainder:

0

[[], 0] = 

0*/

package com.codewars.main;

import java.util.ArrayList;

public class DecomposeANumber {

	public static long[][] decompose( long n ) {
		long b[] = new long[1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		long sum = n;
		for ( int i = 2; sum > 3; i++ ) {
			int temp = (int) ( Math.log( sum ) / Math.log( i ) );
			if ( temp > 1 ) {
				list.add( temp );
				sum -= Math.pow( i, list.get( list.size() - 1 ) );
			} else break;
		}
		long[] a = new long[list.size()];
		for ( int i = 0; i < list.size(); i++ )
			a[i] = list.get( i );
		b[0] = sum;
		return new long[][] { a, b };
	}
}
