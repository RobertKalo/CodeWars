package com.codewars.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main( String[] args ) {

		String string = "1\\n2\\n3";
		Pattern pattern = Pattern.compile( "($)" );
		Matcher matcher = pattern.matcher( string );
		
		while ( matcher.find() ) {
			System.out.println( matcher.group() );
		}
	}

}
