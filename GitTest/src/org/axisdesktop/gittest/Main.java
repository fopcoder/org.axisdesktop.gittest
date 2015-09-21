package org.axisdesktop.gittest;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main( String[] args ) {
		System.out.println( "git test" );
		List<Category> data = new ArrayList<>();

		String[][] d = { { "catalog", "/", "1", "30" },
				{ "klimat", "/klimat", "16", "21" },
				{ "хуй 26", "/khui", "2", "15" },
				{ "deti", "/deti", "22", "27" },
				{ "Кондиционеры", "/klimat/air-conder", "17", "20" },
				{ "kolyaski", "/deti/kolya99900", "23", "26" },
				{ "input", "", "28", "29" }, { "8989898", "", "7", "14" },
				{ "11111", "", "5", "6" }, { "22222", "/khui/22", "3", "4" },
				{ "333", "", "10", "13" }, { "4444", "", "11", "12" },
				{ "кондудей", "", "18", "19" }, { "лщлщлщ", "", "24", "25" },
				{ "ггг", "", "8", "9" } };

		for( String[] row : d ) {
			data.add( new Category( row ) );
		}

		System.out.println( data );

	}

	public static Category structure( List<Category> listSrc,
			List<Category> listDst, int left, int right ) {

		for( Category cat : listSrc ) {
			if( cat.getLeft() < left || cat.getRight() > right ) continue;

			if( cat.getRight() - cat.getLeft() == 1 ) {
				// listnew Category( cat );
			}
			else {
				structure( listSrc, listDst, cat.getLeft(), cat.getRight() );
			}

		}

		return null;
	}
}

/*
 * 
 * [ "catalog", "/", 1, 30 ], [ "хуй 26", "khui", "/khui" 2 : 15 10 "22222" 22
 * /khui/22 3 : 4 9 "11111" 5 : 6 8 "8989898" 7 : 14 15 "ггг" ggg 8 : 9 11 "333"
 * iii 10 : 13 12 "4444" 11 : 12 2 "klimat" /klimat 16 : 21 5 "Кондиционеры"
 * air-conder /klimat/air-conder 17 : 20 13 "кондудей" 18 : 19 4 "deti" /deti 22
 * : 27 6 "kolyaski" kolya99900 /deti/kolya99900 23 : 26 14 "лщлщлщ" 24 : 25 7
 * "input" 28 : 29
 */