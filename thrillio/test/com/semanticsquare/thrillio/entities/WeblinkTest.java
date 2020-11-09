package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillio.manager.BookmarkManager;

public class WeblinkTest {

	@Test
	public void testisKidFriendlyEligible() {
		//Test1: porn in url --false
		Weblink weblink=BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");
		boolean isKidFriendlyEligible=weblink.isKidFriendlyEligible();
		assertFalse("For porn in url- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		
		//Test2: porn in title --false
		weblink=BookmarkManager.getInstance().createWeblink(2000,"Taming porn, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		 isKidFriendlyEligible=weblink.isKidFriendlyEligible();
		assertFalse("For porn in title- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		//Test3: adult in host --false
		weblink=BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.adult.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		 isKidFriendlyEligible=weblink.isKidFriendlyEligible();
		assertTrue("For adult in host- isKidFriendlyEligible() must return true",isKidFriendlyEligible);
		//Test4 : adult in url, but not in host part --true
		weblink=BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.javaworld.com");
		 isKidFriendlyEligible=weblink.isKidFriendlyEligible();
		assertTrue("For adult in url,but not in host part- isKidFriendlyEligible() must return true",isKidFriendlyEligible);
		//Test5: adult in title only--true
		weblink=BookmarkManager.getInstance().createWeblink(2000,"Taming adult, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		 isKidFriendlyEligible=weblink.isKidFriendlyEligible();
		assertTrue("For adult in title only - isKidFriendlyEligible() must return true",isKidFriendlyEligible);
		
	}

}
