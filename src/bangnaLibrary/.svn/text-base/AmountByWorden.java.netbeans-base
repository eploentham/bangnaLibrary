/*
 *  Java bussiness API
 *
 *  Copyright (C) 2003 Igor Artimenko.
 *
 *  Written by: 2003 Igor Artimenko <igorart7@yahoo.com>
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Library General Public License
 *  as published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Library General Public License for more details.
 *
 *  You should have received a copy of the GNU Library General Public
 *  License along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
 
package bangnaLibrary;

import java.math.BigDecimal;
import java.util.TreeMap;

/**
 * The purpose is to return string representation on the number 
 * in the human-readable format based on English grammar 
 * Generally you can use this class as a base for your own language 
 * like Russian, German, Spanish, French etc. 
 * They must implement IAmountByWord interface
 *   
 * @author Igor Artimenko <igorart7@yahoo.com>
 * 
 * @version 1.0 Initial draft for review  
 * Created on Jun 5, 2003
 * 
 */
public class AmountByWorden implements IAmountByWord{
	final private TreeMap langTokens = new TreeMap(); 
//	private String currency = null;
        private String currency = "TH";
	public AmountByWorden(){
		super();
		langTokens.put( "0", "zero" );		
		langTokens.put( "1", "one" );
		langTokens.put( "2", "two" );
		langTokens.put( "3", "three" );
		langTokens.put( "4", "four" );
		langTokens.put( "5", "five" );
		langTokens.put( "6", "six" );
		langTokens.put( "7", "seven" );
		langTokens.put( "8", "eight" );
		langTokens.put( "9", "nine" );
		langTokens.put( "10", "ten" );
		langTokens.put( "11", "eleven" );
		langTokens.put( "12", "twelve" );
		langTokens.put( "13", "thirteen" );
		langTokens.put( "14", "fourteen" );
		langTokens.put( "15", "fifteen" );
		langTokens.put( "16", "sixteen" );
		langTokens.put( "17", "seventeen" );
		langTokens.put( "18", "eighteen" );		
		langTokens.put( "19", "nineteen" );
		langTokens.put( "20", "twenty" );
		langTokens.put( "30", "thirty" );
		langTokens.put( "40", "fourty" );
		langTokens.put( "50", "fifty" );
		langTokens.put( "60", "sixty" );
		langTokens.put( "70", "seventy" );
		langTokens.put( "80", "eighty" );
		langTokens.put( "90", "ninety" );
		langTokens.put( "100", "hundred" );		
		langTokens.put( "1000", "thousand" );
		langTokens.put( "1000000", "million" );
		langTokens.put( "1000000000", "billion" );
		langTokens.put( "1000000000000", "trillion" );
		langTokens.put( "minus", "minus" );
		langTokens.put( "and", "and" );
		langTokens.put( "point", "point" );
	}
		
	/* (non-Javadoc) 	
	 * @see org.apache.bussinessapi.IAmountByWord#getAmountByWord(double)
	 */
	public String getAmountByWord( double amount ) throws Exception{

		NumberByWord numberByWord = new NumberByWord();
		StringBuffer fullNumber = new StringBuffer();
		
		numberByWord.setLanguageTokens( langTokens );
		
		// also should be replaced by full phrase
		fullNumber = fullNumber.append( 
				numberByWord.getNumberByWord( (long) amount ).trim() );
		
		BigDecimal dec1 =  new BigDecimal( amount ).setScale( 2, BigDecimal.ROUND_HALF_UP);
		String theRestStr =  dec1.toString();

		theRestStr = theRestStr.substring( theRestStr.length() - 2 );	

		int theRest = new Integer( theRestStr ).intValue();
		if ( theRest != 0 )
		{
			fullNumber.append( " " ). append( langTokens.get( "point" ) ).
					append( " " ).append(	
					numberByWord.getNumberByWord( (long) theRest ).trim() );
		}
		
		return fullNumber.toString(); 		
	}

	/* (non-Javadoc) 	
	 * @see org.apache.bussinessapi.IAmountByWord#getMoneyAmountByWord(double)
	 */
	public String getMoneyAmountByWord( double amount ) throws Exception
	{

		NumberByWord numberByWord = new NumberByWord();
		StringBuffer fullNumber = new StringBuffer();
		String[]  str = LanguageCurrency.getSupportedBanknoteName(  "en", currency );
		
		numberByWord.setLanguageTokens( langTokens );
		
		// also should be replaced by full phrase
		fullNumber = fullNumber.append( 
				numberByWord.getNumberByWord( (long) amount ).trim() );
		
		fullNumber.append( " " ). append( str[0]  ) ;
		if (  (long)amount != 1 ) {
			fullNumber.append( "s" );
		}
		
		BigDecimal dec1 =  new BigDecimal( amount ).setScale( 2, BigDecimal.ROUND_HALF_UP);
		String theRest =  dec1.toString();

		theRest = theRest.substring( theRest.length() - 2 );
		fullNumber.append( " " ).append(	theRest ).append( " " ).append( str[1] );
		
		if ( !theRest.equals( "01"  )  ) {
			fullNumber.append( "s" );
		}
		
		return fullNumber.toString(); 		
	}
	
	public void setCurrency( String aCurrency )
	{
		this.currency = aCurrency;
	}
	
}
