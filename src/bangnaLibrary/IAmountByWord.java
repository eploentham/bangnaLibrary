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

/**
 * Each class created for the purpose of giving back 
 * a string representation of the number MUST implement this interface
 * 
 * @author Igor Artimenko <igorart7@yahoo.com>
 *   
 * @version 1.0 Initial draft for review 
 * Created on Jun 5, 2003
 * 
 */
public interface IAmountByWord {
	
	/**
	 * getMoneyAmountByWord  The purpose of this method is to return 
	 * string representation on the number in the human-readable format
	 * in a regular format ( like 25.78  
	 * "twenty five point seventy eight" )
	 * 
	 * @param anAmount to be converted into it's string representation
	 * @return A string representation of the number
	 * @throws Exception if something went wrong
	 */
	public String getAmountByWord( double anAmount ) throws Exception;


	/**
	 * getMoneyAmountByWord  The purpose of this method is to return 
	 * string representation on the number in the human-readable format
	 * in a money format like ( 25.78 Can 
	 * "twenty five Canadian Dollars 78 Cents" )
	 *  
	 * @param anAmount to be converted into it's string representation
	 * @return A string representation of the number
	 * @throws Exception if something went wrong
	 */
	public String getMoneyAmountByWord( double anAmount ) 
			throws Exception;
			
	/**
	 * setCurrency 
	 * @return To setup Currency locale code to be used
	 */ 
	public void setCurrency( String currency );		
					
}
