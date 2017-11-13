/*#Sort the columns of a csv-file

You get a string with the content of a csv-file. The columns are separated by semicolons.
The first line contains the names of the columns.
Write a method that sorts the columns by the names of the columns alphabetically and incasesensitive.

An example:

Before sorting:
As table (only visualization):
|myjinxin2015|raulbc777|smile67|Dentzil|SteffenVogel_79|
|17945       |10091    |10088  |3907   |10132          |
|2           |12       |13     |48     |11             |

The csv-file:
myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n
17945;10091;10088;3907;10132\n
2;12;13;48;11

----------------------------------

After sorting:
As table (only visualization):
|Dentzil|myjinxin2015|raulbc777|smile67|SteffenVogel_79|
|3907   |17945       |10091    |10088  |10132          |
|48     |2           |12       |13     |11             |

The csv-file:
Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n
3907;17945;10091;10088;10132\n
48;2;12;13;11
There is no need for prechecks. You will always get a correct string with more than 1 line und more than 1 row. All columns will have different names.

Have fun coding it and please don't forget to vote and rank this kata! :-)

I have created other katas. Have a look if you like coding and challenges.
 */

package com.codewars.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortColumnsCSV {


	public static String sortCsvColumns( String csvFileContent ) {

		Map<Integer, String> columns = new HashMap<Integer, String>();

		getColumnNames( csvFileContent, columns );

		int[] sortedColumns = sortMapByValue( columns );
		// System.out.print( "*** sortedColumn: " );
		// for ( int i = 0; i < sortedColumns.length; i++ ) {
		//
		// System.out.print( sortedColumns[i] + " " );
		// }

		return sortColumns( sortedColumns, csvFileContent );
	}

	private static void getColumnNames( String csvFileContent, Map<Integer, String> columns ) {
		Pattern pattern = Pattern.compile( "([^;\\n]+)([;\\n])" );
		Matcher matcher = pattern.matcher( csvFileContent );

		int i = 0;
		while ( matcher.find() && !matcher.group( 2 ).equals( "\n" ) ) {
			columns.put( i, matcher.group( 1 ) );
			i++;
		}
		columns.put( i, matcher.group( 1 ) );

//		pritOutMap( columns );
		// System.out.println( "*** The column names input is ready" );

	}

//	private static void pritOutMap( Map<Integer, String> map ) {
//
//		for ( int i = 0; i < map.size(); i++ ) {
//			System.out.println( map.get( i ) );
//		}
//	}

	private static int[] sortMapByValue( Map<Integer, String> unsortedMap ) {
		LinkedList<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(
				(Collection<? extends Entry<Integer, String>>) unsortedMap.entrySet() );

		Collections.sort( list, new Comparator<Map.Entry<Integer, String>>() {
			public int compare( Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2 ) {
				return o1.getValue().toLowerCase().compareTo( o2.getValue().toLowerCase() );
			}
		} );

		int[] sortedColumns = new int[unsortedMap.size()];
		int i = 0;
		for ( Map.Entry<Integer, String> entry : list ) {
			sortedColumns[i] = entry.getKey();
			i++;
		}

		return sortedColumns;

	}

	private static String sortColumns( int[] sortedColumns, String csvFileContent ) {

		StringBuffer resultString = new StringBuffer();

		ArrayList<String> csvElements = new ArrayList<String>( Arrays.asList( csvFileContent.split( "[;\\n]" ) ) );

		// for ( int i = 0; i < csvElements.size(); i++ ) {
		// System.out.println( csvElements.get( i ) );
		// }

		for ( int j = 0; j < csvElements.size() / sortedColumns.length; j++ ) {
			for ( int i = 0; i < sortedColumns.length; i++ ) {

				resultString.append( csvElements.get( j * sortedColumns.length + sortedColumns[i] ) );
				if ( i < sortedColumns.length - 1 ) {

					resultString.append( ";" );
				}
			}
			if ( j < csvElements.size() / sortedColumns.length - 1 ) {
				resultString.append( "\n" );
			}
		}
		return resultString.toString();
	}
}