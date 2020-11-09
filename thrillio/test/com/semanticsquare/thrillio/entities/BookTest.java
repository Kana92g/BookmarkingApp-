package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillio.manager.BookmarkManager;

public class BookTest {

	@Test
	public void testisKidFriendlyEligible() {
		//Test1: 
		Book book=BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String [] {"Henry David Thoreau"},"Philosophy",4.3);
		boolean isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse("For Philosophy genre- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		
		//Test2:
		book=BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String [] {"Henry David Thoreau"},"Self_Help",4.3);
		 isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse("For Self_Help genre- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
}

}
