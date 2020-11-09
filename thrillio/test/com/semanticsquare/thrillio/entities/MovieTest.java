package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillio.manager.BookmarkManager;

public class MovieTest {

	@Test
		public void testisKidFriendlyEligible() {
			//Test1: 
			Movie movie=BookmarkManager.getInstance().createMovie(3000,"Citizen Kane",1941,new String [] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},"Horror",8.5);
			boolean isKidFriendlyEligible=movie.isKidFriendlyEligible();
			assertFalse("For Horror genre- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
			
			//Test2:
			movie=BookmarkManager.getInstance().createMovie(3000,"Citizen Kane",1941,new String [] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},"Thriller",8.5);
			 isKidFriendlyEligible=movie.isKidFriendlyEligible();
			assertFalse("For Thriller genre- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
	}

}
