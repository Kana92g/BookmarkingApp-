package com.semanticsquare.thrillio.entities;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

public class Movie extends Bookmark {
	private int releaseYear;
	private String[] cast;
	private String [] director;
	private String genre;
	private double imdbRating;
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear=releaseYear;
	}
	public String[] getCast() {
		return cast;
	}
	public void setCast(String[] cast) {
		this.cast = cast;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String [] getDirector() {
		return director;
	}
	public void setDirector(String [] director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", director="
				+ Arrays.toString(director) + ", genre=" + genre + ", imdbRating=" + imdbRating + "]";
	}
	
	@Override
	public  boolean isKidFriendlyEligible() {
		if(getGenre().contains("Horror")||getGenre().contains("Thriller")) {
			return false;
		}
		return true;
	}
	@Override
	public String getItemData() {
		StringBuilder builder= new StringBuilder();
		builder.append("<items>");
		builder.append("<type>Movie</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<releaseYear>").append(releaseYear).append("</releaseYar>");
		builder.append("<cast>").append(StringUtils.join(cast, " ,")).append("cast");
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<imdbRating>").append(imdbRating).append("</imdbRating>");
		builder.append("<director>").append(StringUtils.join(director, " ,")).append("</director>");
		builder.append("</item>");
		
		return builder.toString();
		
	}
}




