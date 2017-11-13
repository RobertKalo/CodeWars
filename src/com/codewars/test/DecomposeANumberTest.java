package com.codewars.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.codewars.main.DecomposeANumber;

import java.util.Arrays;

public class DecomposeANumberTest {

	private static void testing( String actual, String expected ) {
		assertEquals( expected, actual );
	}

	@Test
	public void test() {
		System.out.println( "Fixed Tests decompose" );
		long[][] ans = DecomposeANumber.decompose( 0 );
		String ansStr = Arrays.toString( ans[0] ) + Arrays.toString( ans[1] );
		testing( ansStr, "[][0]" );
		ans = DecomposeANumber.decompose( 4 );
		ansStr = Arrays.toString( ans[0] ) + Arrays.toString( ans[1] );
		testing( ansStr, "[2][0]" );
		ans = DecomposeANumber.decompose( 9 );
		ansStr = Arrays.toString( ans[0] ) + Arrays.toString( ans[1] );
		testing( ansStr, "[3][1]" );
		ans = DecomposeANumber.decompose( 25 );
		ansStr = Arrays.toString( ans[0] ) + Arrays.toString( ans[1] );
		testing( ansStr, "[4, 2][0]" );
		ans = DecomposeANumber.decompose( 45 );
		ansStr = Arrays.toString( ans[0] ) + Arrays.toString( ans[1] );
		testing( ansStr, "[5, 2][4]" );
	}
}
