package com.codewars.main;

public class NextBiggerNumber {

	public static long nextBiggerNumber( long n ) {

		char[] charArray = Long.toString( n ).toCharArray();
		int[] numbers = new int[charArray.length];
		for ( int i = 0; i < charArray.length; i++ ) {
			numbers[i] = charArray[i];
		}
		
		return -1;

	}
}
