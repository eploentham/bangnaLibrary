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

import java.util.TreeMap;

/**
 * Utility class to keep most offen used currencies names here.
 *  
 * 
 * @author Igor Artimenko <igorart7@yahoo.com>
 * 
 * @version 1.0 Initial draft for review 
 * Created on Jun 9, 2003
 * 
 */
public final class LanguageCurrency {
	
	// supportedLanguages & supportedCurrencies list are mandatory to fill up
	// for new languages used in the package 
	public final static TreeMap supportedLanguages = new TreeMap();
	public final static TreeMap supportedCurrencies = new TreeMap();
	// banknoteName is optional to fiil up for new languages but desired
	public final static TreeMap banknoteName = new TreeMap();
	private static TreeMap currencies = null;	

	static
	{
		// supportedLanguages labels suppose to be 
		// written in Unicode in few official languages 
		// for this country separated by comma 
		// mostly for User Interface purposes	
		// Mandatory list
		supportedLanguages.put( "en", "English" );
		supportedLanguages.put( "ru", "Русский" );
					
		// supportedCurrencies labels suppose to be 
		// written in Unicode in few official languages 
		// for this country separated by comma 
		// mostly for User Interface purposes
	  // Mandatory list
	  		
	  // English							
		supportedCurrencies.put( "US", "USA Currency" );			
		supportedCurrencies.put( "CA", "Canadian Currency, French Name of Canadian Currency" );
		supportedCurrencies.put( "GB", "Currency of Great Britan" );
		supportedCurrencies.put( "EU", "Euro Currency" );			
		supportedCurrencies.put( "RU", "Российская Валюта" );
		supportedCurrencies.put( "CN", "Chineese Currency" );			
	  supportedCurrencies.put( "IN", "Indian Currency" );
	  																
		// supportedCurrencies labels suppose to be 
		// written in Unicode in few official languages 
		// for this country separated by comma 
		// mostly for User Interface purposes
		currencies = new TreeMap(); 	
		currencies.put( "US", new String[] { "US Dollar", "Cent" } );
		currencies.put( "CA", new String[] { "Canadian Dollar", "Cent" } );
		currencies.put( "GB", new String[] { "Pound Sterling", "Penny" } );
		currencies.put( "EU", new String[] { "Euro", "Cent" } );
		currencies.put( "RU", new String[] { "Russian Rouble", "Kopeyka" } );
		currencies.put( "CN", new String[] { "Chinese Yaun", "Fen" } );
		currencies.put( "IN", new String[] {  "Indian Rupee", "Paise" } );
                currencies.put( "TH", new String[] {  " ", "" } );
	  banknoteName.put( "en", currencies );
	  			
	  // Русский			
	  currencies = new TreeMap();	  								
	  currencies.put( "US", new String[] { "Доллар США", "Цент" } );
	  currencies.put( "CA", new String[] { "Канадский Доллар", "Цент" } );
	  currencies.put( "GB", new String[] { "Фунт Стерлинг", "Пенни" } );
	  currencies.put( "EU", new String[] { "Евро", "Цент" } );
	  currencies.put( "RU", new String[] { "Российский рубль", "Копейка" } );
	  currencies.put( "CN", new String[] { "Китайский Янь", "Фэн" } );
	  currencies.put( "IN", new String[] { "Индийский Рупий", "Пес" } );
	  banknoteName.put( "ru", currencies );

	}
	
	public static TreeMap getSupportedCurrencies()
	{
		return supportedCurrencies;
	}
	
	public static TreeMap getSupportedLanguages()
	{
		return supportedLanguages;
	}	

	public static TreeMap getSupportedBanknoteNames()
	{
		return banknoteName;
	}

	public static String[] getSupportedBanknoteName( String aSupportedLanguage, 
		String aSupportedCurrency )
	{
		String[] aSupportedBanknoteName = null; 
		
		TreeMap supportedBankNote = ( TreeMap ) banknoteName.get( aSupportedLanguage );
		
		if ( supportedBankNote != null ) {
			
			aSupportedBanknoteName = ( String[] ) supportedBankNote.get( aSupportedCurrency ) ;
			
		}
		
		return aSupportedBanknoteName;
	}
			
}
