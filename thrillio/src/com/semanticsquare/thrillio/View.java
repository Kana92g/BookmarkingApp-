package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partners.Shareable;

public class View {

	public static void browse (User user, Bookmark[][] bookmarks) {
		System.out.println("\n"+user.getEmail()+ " is browsing items");
		int bookmarkCount=0;
		for(Bookmark[] bookmarkList:bookmarks) {
			for(Bookmark bookmark:bookmarkList) {
				if(bookmarkCount<DataStore.BOOKMARK_USER_LIMIT) {
					boolean isBookmarked=getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user,bookmark);
						System.out.println("New item bookmarked.."+bookmark);
					}
					
				}
			
				if(user.getUserType().equals(UserType.EDITOR)||user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					//Mark as kid friendly
					if(bookmark.isKidFriendlyEligible()&&bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String KidFriendlyStatus= getKidFriendlyStatusDecision();
						if(!KidFriendlyStatus.equals("unknown")) {
							BookmarkController.getInstance().setKidFriendlyStatus(user,KidFriendlyStatus, bookmark);
							bookmark.setKidFriendlyStatus(KidFriendlyStatus);
							System.out.println("KidFriendlyStatus:"+KidFriendlyStatus+" ,"+ bookmark);
						}
					}
			}
		//Shareable
				if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)&& bookmark instanceof Shareable) {
					boolean isShared=getShareDecision();
					if(isShared) {
						BookmarkController.getInstance().share(user,bookmark);
					}
					
				}
	}
	}
	}
		


	private static boolean getShareDecision() {
		return Math.random()<0.5?true:false;
		
	}



	private static String getKidFriendlyStatusDecision() {
		return Math.random()<0.4?KidFriendlyStatus.APPROVED: (Math.random()>=0.5 && Math.random()<0.8)?KidFriendlyStatus.REJECTED:KidFriendlyStatus.UNKNOWN;
		
		
	}



	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random()<0.5?true:false;
		
	}

}
