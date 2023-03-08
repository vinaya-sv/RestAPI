package com.example.demo.model; 

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Theatre {
	@Id
	private int theatreId;
	private String theatreName;
	private String theatreAddress;
	private int rating;
	
	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreAddress=" + theatreAddress
				+ ", rating=" + rating + "]";
	}
		
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreAddress() {
		return theatreAddress;
	}
	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
