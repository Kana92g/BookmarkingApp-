package com.semanticsquare.thrillio.entities;

public abstract class  Bookmark {
	private long id;
	private String title;
	private String profileUrl;
	private String kidFriendlyStatus="unkonown";
	private User kidFriendyMarkedBy;
	private User sharedBy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public abstract boolean isKidFriendlyEligible();
	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}
	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}
	public abstract String getItemData();
	public User getKidFriendyMarkedBy() {
		return kidFriendyMarkedBy;
	}
	public void setKidFriendyMarkedBy(User kidFriendyMarkedBy) {
		this.kidFriendyMarkedBy = kidFriendyMarkedBy;
	}
	public User getSharedBy() {
		return sharedBy;
	}
	public void setSharedBy(User user) {
		this.sharedBy = user;
	}
	

}
