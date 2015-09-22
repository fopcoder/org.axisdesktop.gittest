package org.axisdesktop.gittest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main( String[] args ) {
		System.out.println( "git test" );
		List<Category> data = new ArrayList<>();

		String[][] d = { { "catalog", "/", "1", "32" },
				{ "хуй 269999", "", "2", "17" }, { "899898989", "", "3", "4" },
				{ "22222", "/khui/22", "5", "6" }, { "11111", "", "7", "8" },
				{ "8989898", "", "9", "16" }, { "ггг", "", "10", "11" },
				{ "333", "", "12", "15" }, { "4444", "", "13", "14" },
				{ "klimat", "/klimat", "18", "23" },
				{ "Кондиционеры", "/klimat/air-conder", "19", "22" },
				{ "кондудей", "", "20", "21" },
				{ "deti", "/deti", "24", "29" },
				{ "kolyaski", "/deti/kolya99900", "25", "28" },
				{ "лщлщлщ", "", "26", "27" }, { "input", "", "30", "31" }, };

		for( String[] row : d ) {
			data.add( new Category( row ) );
		}

		// System.out.println( struct( data, data.get( 0 ) ) );
		Category root = struct( data, data.remove( 0 ) );
		System.out.println( root );
		System.out.println( "------------" );
		System.out.println( data );
		for( Category cc : root.getChildren() ) {
			System.out.println( cc.getName() );
			for( Category dd : cc.getChildren() ) {
				System.out.println( "  " + dd.getName() );
				for( Category ee : dd.getChildren() ) {
					System.out.println( "    " + ee.getName() );
				}
			}
		}

	}

	// public static Category structure( List<Category> listSrc,
	// List<Category> listDst, int left, int right ) {
	//
	// for( Category cat : listSrc ) {
	// if( cat.getLeft() < left || cat.getRight() > right ) continue;
	//
	// if( cat.getRight() - cat.getLeft() == 1 ) {
	// // listnew Category( cat );
	// }
	// else {
	// structure( listSrc, listDst, cat.getLeft(), cat.getRight() );
	// }
	//
	// }
	//
	// return null;
	// }

	public static Category struct( List<Category> list, Category cat ) {
		Category catNew = new Category( cat );
		// Category cc;// = new Category( cat );

		for( ListIterator<Category> ci = list.listIterator(); ci.hasNext(); ) {
			Category cc = ci.next();
			// ci.set( null );

			if( cc == null || catNew.getLeft() >= cc.getLeft()
					|| cat.getRight() <= cc.getRight() ) continue;
			// ci.set( null );
			// System.out.println( cc.getName() );

			if( cc.getRight() - cc.getLeft() == 1 ) {
				ci.set( null );
				catNew.getChildren().add( new Category( cc ) );

				// ci.remove();
			}
			else {
				ci.set( null );
				catNew.getChildren().add( struct( list, cc ) );
				// cc = null;

			}

		}

		// for( Iterator<Category> ci = list.iterator(); ci.hasNext(); ) {
		// Category cc = ci.next();
		// // ci.remove();
		// if( cat.getLeft() >= cc.getLeft() || cat.getRight() <= cc.getRight()
		// ) continue;
		//
		// System.out.println( cc.getName() );
		// if( cc.getRight() - cc.getLeft() == 1 ) {
		// cat.getChildren().add( cc );
		// ci.remove();
		// }
		// else {
		// cat.getChildren().add( struct( list, cc ) );
		// }
		// }

		return catNew;
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